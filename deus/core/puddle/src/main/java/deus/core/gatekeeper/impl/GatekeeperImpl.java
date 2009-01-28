package deus.core.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.User;
import deus.core.UserFactory;
import deus.core.UserRegistry;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.LoginCredentialChecker;
import deus.core.gatekeeper.soul.LoginCredentials;


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
