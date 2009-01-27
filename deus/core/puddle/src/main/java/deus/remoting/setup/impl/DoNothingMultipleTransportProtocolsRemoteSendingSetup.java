package deus.remoting.setup.impl;

import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.Subsystem;
import deus.remoting.setup.MultiRemoteSendingSetup;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

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
