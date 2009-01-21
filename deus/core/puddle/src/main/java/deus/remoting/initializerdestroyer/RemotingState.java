package deus.remoting.initializerdestroyer;

import deus.model.user.id.UserIdType;

public interface RemotingState {

	public boolean isRemotingAvailable();
	
	public UserIdType getUserIdType();
	
}
