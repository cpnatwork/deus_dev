package deus.remoting.initializerdestroyer;

import deus.core.User;


public interface RemoteCommand {

	public void execute(User user);
	
}
