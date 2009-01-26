package deus.remoting.command;

import deus.remoting.state.RemotingState;


public interface RemoteCommandDecorator extends RemoteCommand {

	public abstract void beforeExecute(RemotingState remotingState);


	public abstract void afterExecute(RemotingState remotingState);


	public abstract void setDecoratedRemoteCommand(RemoteCommand remoteCommand);

}