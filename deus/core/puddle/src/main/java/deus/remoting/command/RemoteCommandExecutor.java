package deus.remoting.command;

import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

public class RemoteCommandExecutor {

	private final RemotingStateRegistry remotingStateRegistry;
	private RemoteCommandDecorator decorator;
	
	
	public RemoteCommandExecutor(RemotingStateRegistry remotingStateRegistry) {
		super();
		this.remotingStateRegistry = remotingStateRegistry;
	}


	/**
	 * This methods chooses a transport id type, using the given UserId
	 * @param userId
	 * @return
	 */
	protected TransportIdType choseTransportIdType(UserId userId) {
		// FIXME: implement!!!
		return TransportIdType.local;
	}
	
	
	public void execute(RemoteCommand remoteCommand, UserId userId) {
		TransportIdType transportIdType = choseTransportIdType(userId);
		RemotingState remotingState = remotingStateRegistry.getRemotingState(transportIdType);
		if(decorator != null) {
			decorator.setDecoratedRemoteCommand(remoteCommand);
			decorator.execute(remotingState);
		}
		else
			remoteCommand.execute(remotingState);

	
	}

	public void setRemoteCommandDecorator(RemoteCommandDecorator decorator) {
		this.decorator = decorator;
	}
}
