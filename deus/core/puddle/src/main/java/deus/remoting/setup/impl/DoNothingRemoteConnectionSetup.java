package deus.remoting.setup.impl;

import deus.core.User;
import deus.remoting.setup.RemoteConnectionSetup;

public class DoNothingRemoteConnectionSetup implements RemoteConnectionSetup {

	@Override
	public void setUp(User user) {
		// do nothing!
	}


	@Override
	public void tearDown(User user) {
		// do nothing!
	}

}
