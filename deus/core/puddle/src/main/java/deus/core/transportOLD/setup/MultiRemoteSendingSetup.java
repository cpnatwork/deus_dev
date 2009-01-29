package deus.core.transportOLD.setup;

import deus.core.transportOLD.command.Subsystem;
import deus.core.transportOLD.state.RemotingState;
import deus.core.transportOLD.state.RemotingStateRegistry;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;


public interface MultiRemoteSendingSetup {

	public abstract RemotingState setUpSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type,
			UserId receiverId, Subsystem receiverSubsystem);


	public abstract void tearDownSending(RemotingStateRegistry remotingStateRegistry, TransportIdType type,
			UserId receiverId, Subsystem receiverSubsystem);

}