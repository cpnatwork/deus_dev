package deus.core.transportOLD.setup.impl;

import java.util.Map;

import deus.core.transportOLD.command.Subsystem;
import deus.core.transportOLD.setup.MultiRemoteSendingSetup;
import deus.core.transportOLD.setup.RemoteSendingSetup;
import deus.core.transportOLD.state.RemotingState;
import deus.core.transportOLD.state.RemotingStateRegistry;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

public class MultiRemoteSendingSetupImpl implements MultiRemoteSendingSetup {

	private final Map<TransportIdType, RemoteSendingSetup> remoteSendingSetups;


	public MultiRemoteSendingSetupImpl(Map<TransportIdType, RemoteSendingSetup> remoteSendingSetups) {
		super();
		this.remoteSendingSetups = remoteSendingSetups;
	}


	/* (non-Javadoc)
	 * @see deus.core.transport.setup.impl.MultipleTransportProtocolsRemoteSendingSetup#setUpSending(deus.core.transport.state.RemotingStateRegistry, deus.model.user.transportid.TransportIdType, deus.model.user.id.UserId, deus.core.transport.command.Subsystem)
	 */
	public RemotingState setUpSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type, UserId receiverId,
			Subsystem receiverSubsystem) {
		if (!remotingStateRegistry.hasRemotingState(type))
			throw new IllegalStateException("Can't setup remote sending for protocol " + type
					+ "! There is no remoting state for the transport protocol " + type
					+ " registered! Set up remote connection first!");

		RemotingState remotingState = remotingStateRegistry.getRemotingState(type);

		RemoteSendingSetup remoteSendingSetup = remoteSendingSetups.get(type);
		if (remoteSendingSetup == null)
			throw new RuntimeException("Cannot setup sending. There is no RemoteSendingSetup for transport protocol "
					+ type + " registered!");

		remoteSendingSetup.setUpSending(remotingState, receiverId, receiverSubsystem);
		
		return remotingState;
	}


	/* (non-Javadoc)
	 * @see deus.core.transport.setup.impl.MultipleTransportProtocolsRemoteSendingSetup#tearDownSending(deus.core.transport.state.RemotingStateRegistry, deus.model.user.transportid.TransportIdType, deus.model.user.id.UserId, deus.core.transport.command.Subsystem)
	 */
	public void tearDownSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type, UserId receiverId,
			Subsystem receiverSubsystem) {
		if (!remotingStateRegistry.hasRemotingState(type))
			throw new IllegalStateException("Can't tear down remote sending for protocol " + type
					+ "! There is no remoting state for the transport protocol " + type
					+ " registered! Set up remote connection first!");

		RemotingState remotingState = remotingStateRegistry.getRemotingState(type);

		RemoteSendingSetup remoteSendingSetup = remoteSendingSetups.get(type);
		if (remoteSendingSetup == null)
			throw new RuntimeException(
					"Cannot tear down sending. There is no RemoteSendingSetup for transport protocol " + type
							+ " registered!");

		remoteSendingSetup.tearDownSending(remotingState, receiverId, receiverSubsystem);
	}

}
