package deus.remoting.initializerdestroyer.impl;

import deus.core.User;
import deus.remoting.initializerdestroyer.RemotingInitializerDestroyer;

public class DoNothingRemotingInitializerDestroyer implements RemotingInitializerDestroyer {

	@Override
	public void setUp(User user) {
		// do nothing!
	}


	@Override
	public void tearDown(User user) {
		// do nothing!
	}

}
