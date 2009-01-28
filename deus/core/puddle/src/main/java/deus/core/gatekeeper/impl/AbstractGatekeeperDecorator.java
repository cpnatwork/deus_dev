package deus.core.gatekeeper.impl;


import org.springframework.beans.factory.annotation.Autowired;

import deus.core.User;
import deus.core.UserRegistry;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.soul.LoginCredentials;

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
