package deus.core.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.remoting.initializerdestroyer.RemoteSendingInitializerDestroyer;
import deus.remoting.initializerdestroyer.RemotingInitializerDestroyer;

public class InitDestroyGatekeeperDecorator extends AbstractGatekeeperDecorator {

	@Autowired
	@Qualifier("gatekeeper")
	private RemotingInitializerDestroyer remotingInitializerDestroyer;

	@Autowired
	@Qualifier("gatekeeper")
	private RemoteSendingInitializerDestroyer remoteSendingInitializerDestroyer;

	
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
