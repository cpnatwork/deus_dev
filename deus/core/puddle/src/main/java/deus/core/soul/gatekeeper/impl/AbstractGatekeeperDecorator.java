package deus.core.soul.gatekeeper.impl;


import org.springframework.beans.factory.annotation.Autowired;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.gatekeeper.Gatekeeper;
import deus.core.soul.gatekeeper.soul.LoginCredentials;

public abstract class AbstractGatekeeperDecorator implements Gatekeeper {

	@Autowired
	private UserRegistry userRegistry;

	private final Gatekeeper decoratedGatekeeper;


	public AbstractGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		this.decoratedGatekeeper = decoratedGatekeeper;
	}


	@Override
	public final void login(LoginCredentials credentials) {
		decoratedGatekeeper.login(credentials);

		User user = userRegistry.getUser(credentials.getLocalUsername());

		doAfterLogin(user);
	}


	@Override
	public final void logout(String localUsername) {
		User user = userRegistry.getUser(localUsername);

		doBeforeLogout(user);

		decoratedGatekeeper.logout(localUsername);
	}


	protected abstract void doAfterLogin(User user);


	protected abstract void doBeforeLogout(User user);

}
