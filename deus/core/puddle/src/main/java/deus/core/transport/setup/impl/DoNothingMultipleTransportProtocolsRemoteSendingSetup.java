package deus.core.transport.setup.impl;

import deus.core.transport.command.Subsystem;
import deus.core.transport.setup.MultiRemoteSendingSetup;
import deus.core.transport.state.RemotingState;
import deus.core.transport.state.RemotingStateRegistry;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

public class DoNothingMultipleTransportProtocolsRemoteSendingSetup implements MultiRemoteSendingSetup {

	@Override
	public RemotingState setUpSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type,
			UserId receiverId, Subsystem receiverSubsystem) {
		// DO NOTHING
		return remotingStateRegistry.getRemotingState(type);
	}

	@Override
	public void tearDownSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type, UserId receiverId,
			Subsystem receiverSubsystem) {
		// DO NOTHING
	}

}
