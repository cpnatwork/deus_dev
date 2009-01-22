package deus.remoting.initializerdestroyer.impl;

import deus.core.User;
import deus.remoting.initializerdestroyer.RemoteSendingInitializerDestroyer;

public class DoNothingRemoteSendingInitializerDestroyer implements RemoteSendingInitializerDestroyer {

	@Override
	public void setUp(User user) {
		// do nothing!
	}


	@Override
	public void tearDown(User user) {
		// do nothing!
	}

}
