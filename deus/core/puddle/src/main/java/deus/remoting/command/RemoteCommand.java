package deus.remoting.command;

import deus.remoting.state.RemotingState;


public interface RemoteCommand {

	public void execute(RemotingState remotingState);

}
