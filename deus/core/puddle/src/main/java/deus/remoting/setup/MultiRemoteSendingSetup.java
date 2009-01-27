package deus.remoting.setup;

import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.Subsystem;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;


public interface MultiRemoteSendingSetup {

	public abstract RemotingState setUpSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type,
			UserId receiverId, Subsystem receiverSubsystem);


	public abstract void tearDownSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type,
			UserId receiverId, Subsystem receiverSubsystem);

}