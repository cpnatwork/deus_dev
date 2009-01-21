package deus.remoting.initializerdestroyer;

import deus.core.User;

public interface InitializerDestroyer {

	public void setUp(User user);
	
	public void tearDown(User user);
	
}
