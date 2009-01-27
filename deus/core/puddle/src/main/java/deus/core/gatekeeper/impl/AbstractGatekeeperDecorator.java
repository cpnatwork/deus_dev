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
		// do check here too, to fail early, if user is not logged in
		if(!user.isLoggedIn())
			throw new IllegalStateException("cannot logout user, he is not logged in!");
		
		doBeforeLogout(user);

		decoratedGatekeeper.logout(user);
	}


	protected abstract void doAfterLogin(User user);


	protected abstract void doBeforeLogout(User user);

}
