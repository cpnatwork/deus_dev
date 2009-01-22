package deus.core.gatekeeper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.User;
import deus.core.UserFactory;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.LoginCredentialChecker;
import deus.core.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;


public class GatekeeperImpl implements Gatekeeper {

	@Autowired
	private LoginCredentialChecker loginCredentialChecker;
	
	@Autowired
	private UserFactory userFactory;
	
	@Override
	public User login(LoginCredentials credentials) {
		UserId userId = loginCredentialChecker.check(credentials);
		
		// TODO: do more login stuff, that is necessary
		
		User user = userFactory.createUser(userId);
		
		return user;
	}


	@Override
	public void logout(User user) {
		if(!user.isLoggedIn())
			throw new IllegalStateException("cannot logout user, he is not logged in!");
		user.setLoggedIn(false);
		
		// TODO: do more logout stuff, that is necessary
	}

}
