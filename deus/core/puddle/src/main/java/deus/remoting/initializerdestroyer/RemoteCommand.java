package deus.remoting.initializerdestroyer;

import deus.model.user.transportid.TransportIdType;



public interface RemoteCommand {

	public void execute(RemotingStateRegistry remotingStateRegistry, TransportIdType transportIdType);
	
}
