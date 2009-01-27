package deus.remoting.setup.impl;

import java.util.Map;

import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.Subsystem;
import deus.remoting.setup.MultiRemoteSendingSetup;
import deus.remoting.setup.RemoteSendingSetup;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

public class MultiRemoteSendingSetupImpl implements MultiRemoteSendingSetup {

	private final Map<TransportIdType, RemoteSendingSetup> remoteSendingSetups;


	public MultiRemoteSendingSetupImpl(Map<TransportIdType, RemoteSendingSetup> remoteSendingSetups) {
		super();
		this.remoteSendingSetups = remoteSendingSetups;
	}


	/* (non-Javadoc)
	 * @see deus.remoting.setup.impl.MultipleTransportProtocolsRemoteSendingSetup#setUpSending(deus.remoting.state.RemotingStateRegistry, deus.model.user.transportid.TransportIdType, deus.model.user.id.UserId, deus.remoting.command.Subsystem)
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
	 * @see deus.remoting.setup.impl.MultipleTransportProtocolsRemoteSendingSetup#tearDownSending(deus.remoting.state.RemotingStateRegistry, deus.model.user.transportid.TransportIdType, deus.model.user.id.UserId, deus.remoting.command.Subsystem)
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
