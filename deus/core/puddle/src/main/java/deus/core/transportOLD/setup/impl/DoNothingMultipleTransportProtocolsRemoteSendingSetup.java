package deus.core.transportOLD.setup.impl;

import deus.core.transportOLD.command.Subsystem;
import deus.core.transportOLD.setup.MultiRemoteSendingSetup;
import deus.core.transportOLD.state.RemotingState;
import deus.core.transportOLD.state.RemotingStateRegistry;
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
