package deus.remoting.setup.impl;

import deus.core.User;
import deus.remoting.setup.RemoteSendingSetup;

public class DoNothingRemoteSendingSetup implements RemoteSendingSetup {

	@Override
	public void setUp(User user) {
		// do nothing!
	}


	@Override
	public void tearDown(User user) {
		// do nothing!
	}

}
