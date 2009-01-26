package deus.core.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.remoting.setup.RemoteConnectionSetup;
import deus.remoting.setup.RemoteSendingSetup;

public class InitDestroyGatekeeperDecorator extends AbstractGatekeeperDecorator {

	@Autowired
	@Qualifier("gatekeeper")
	private RemoteConnectionSetup remotingInitializerDestroyer;

	@Autowired
	@Qualifier("gatekeeper")
	private RemoteSendingSetup remoteSendingInitializerDestroyer;

	
	public InitDestroyGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		super(decoratedGatekeeper);
	}


	@Override
	protected void doAfterLogin(User user) {
		remotingInitializerDestroyer.setUp(user);
		remoteSendingInitializerDestroyer.setUp(user);
	}


	@Override
	protected void doBeforeLogout(User user) {
		remoteSendingInitializerDestroyer.tearDown(user);
		remotingInitializerDestroyer.tearDown(user);
	}


}
