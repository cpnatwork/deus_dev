package deus.remoting.command;

import deus.model.user.transportid.TransportIdType;
import deus.remoting.state.RemotingStateRegistry;



public interface RemoteCommand {

	public void execute(RemotingStateRegistry remotingStateRegistry, TransportIdType transportIdType);
	
}
