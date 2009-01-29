package deus.core.soul.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.soul.User;
import deus.core.soul.UserFactory;
import deus.core.soul.UserRegistry;
import deus.core.soul.gatekeeper.Gatekeeper;
import deus.core.soul.gatekeeper.LoginCredentialChecker;
import deus.core.soul.gatekeeper.soul.LoginCredentials;


public class GatekeeperImpl implements Gatekeeper {

	@Autowired
	private LoginCredentialChecker loginCredentialChecker;

	@Autowired
	private UserRegistry userRegistry;

	@Autowired
	private UserFactory userFactory;


	@Override
	public void login(LoginCredentials credentials) {
		if (!loginCredentialChecker.isValid(credentials))
			// FIXME: think about what to do here
			;

		// TODO: do more login stuff, that is necessary
		User user = userFactory.createUser(credentials.getLocalUsername());


		userRegistry.registerUser(credentials.getLocalUsername(), user);
	}


	@Override
	public void logout(String localUsername) {
		if (!userRegistry.hasUser(localUsername))
			throw new IllegalStateException("cannot unregister user, he was not registered!");
		
		userRegistry.unregisterUser(localUsername);

		// TODO: do more logout stuff, that is necessary
	}

}
