package deus.core.soul.gatekeeper.impl;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.soul.User;
import deus.core.soul.UserFactory;
import deus.core.soul.UserRegistry;
import deus.core.soul.gatekeeper.Gatekeeper;
import deus.core.soul.gatekeeper.LoginCredentialChecker;
import deus.core.soul.gatekeeper.UserLoginStateObserver;
import deus.core.soul.gatekeeper.soul.LoginCredentials;


public class GatekeeperImpl implements Gatekeeper {

	private final List<UserLoginStateObserver> observers;
	
	@Autowired
	private LoginCredentialChecker loginCredentialChecker;

	@Autowired
	private UserRegistry userRegistry;

	@Autowired
	private UserFactory userFactory;

	

	public GatekeeperImpl() {
		super();
		this.observers = new Vector<UserLoginStateObserver>();
	}


	@Override
	public void login(LoginCredentials credentials) {
		if (!loginCredentialChecker.isValid(credentials))
			// FIXME: think about what to do here
			;

		// TODO: do more login stuff, that is necessary
		User user = userFactory.createUser(credentials.getLocalUsername());


		userRegistry.registerUser(credentials.getLocalUsername(), user);
		
		for(UserLoginStateObserver observer : observers)
			observer.loggedIn(user.getUserId());
	}


	@Override
	public void logout(String localUsername) {
		if (!userRegistry.hasUser(localUsername))
			throw new IllegalStateException("cannot unregister user, he was not registered!");

		User user = userRegistry.getUser(localUsername);
		
		userRegistry.unregisterUser(localUsername);

		for(UserLoginStateObserver observer : observers)
			observer.loggedIn(user.getUserId());
	}


	@Override
	public void addUserLoginStateObserver(UserLoginStateObserver observer) {
		observers.add(observer);
	}


	@Override
	public void removeUserLoginStateObserver(UserLoginStateObserver observer) {
		if(observers.remove(observer) == false)
			throw new IllegalArgumentException("observer was not added!");
	}

}
