package deus.core.gatekeeper.impl;


import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.soul.LoginCredentials;

public abstract class AbstractGatekeeperDecorator implements Gatekeeper {

	private final Gatekeeper decoratedGatekeeper;


	public AbstractGatekeeperDecorator(Gatekeeper decoratedGatekeeper) {
		this.decoratedGatekeeper = decoratedGatekeeper;
	}


	@Override
	public final User login(LoginCredentials credentials) {
		User user = decoratedGatekeeper.login(credentials);

		doAfterLogin(user);

		return user;
	}


	@Override
	public final void logout(User user) {
		doBeforeLogout(user);

		decoratedGatekeeper.logout(user);
	}


	protected abstract void doAfterLogin(User user);


	protected abstract void doBeforeLogout(User user);

}
