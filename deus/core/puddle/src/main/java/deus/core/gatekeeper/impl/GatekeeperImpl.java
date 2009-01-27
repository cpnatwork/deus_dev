package deus.core.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.User;
import deus.core.UserRegistry;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.LoginCredentialChecker;
import deus.core.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;


public class GatekeeperImpl implements Gatekeeper {

	@Autowired
	private LoginCredentialChecker loginCredentialChecker;
	
	@Autowired
	private UserRegistry userRegistry;
	
	@Override
	public User login(LoginCredentials credentials) {
		UserId userId = loginCredentialChecker.check(credentials);
		
		// TODO: do more login stuff, that is necessary
		
		User user = userRegistry.createAndRegisterUser(userId);
		
		return user;
	}


	@Override
	public void logout(User user) {
		if(!user.isLoggedIn())
			throw new IllegalStateException("cannot logout user, he is not logged in!");
		user.setLoggedIn(false);
		
		userRegistry.unregisterUser(user.getUserId());
		
		// TODO: do more logout stuff, that is necessary
	}

}
