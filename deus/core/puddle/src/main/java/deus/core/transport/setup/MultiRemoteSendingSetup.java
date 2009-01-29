package deus.core.transport.setup;

import deus.core.transport.command.Subsystem;
import deus.core.transport.state.RemotingState;
import deus.core.transport.state.RemotingStateRegistry;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;


public interface MultiRemoteSendingSetup {

	public abstract RemotingState setUpSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type,
			UserId receiverId, Subsystem receiverSubsystem);


	public abstract void tearDownSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type,
			UserId receiverId, Subsystem receiverSubsystem);

}