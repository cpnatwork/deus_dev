package deus.gatekeeper.impl;

import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.gatekeeper.Gatekeeper;
import deus.gatekeeper.LoginCredentialChecker;
import deus.gatekeeper.UserIdFactory;
import deus.gatekeeper.UserLoginStateObserver;
import deus.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;

@Component("gatekeeper")
public class GatekeeperImpl implements Gatekeeper {

	private final Logger logger = LoggerFactory.getLogger(GatekeeperImpl.class);
	
	private final List<UserLoginStateObserver> observers;

	@Autowired
	private LoginCredentialChecker loginCredentialChecker;

	@Autowired
	private UserIdFactory userIdFactory;


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
		UserId userId = userIdFactory.createUserId(credentials.getLocalUsername());
		
		logger.debug("user with id {} logged in", userId);

		for (UserLoginStateObserver observer : observers)
			observer.loggedIn(credentials.getLocalUsername(), userId);
	}


	@Override
	public void logout(String localUsername) {
		UserId userId = userIdFactory.createUserId(localUsername);

		logger.debug("user with id {} logged out", userId);
		
		for (UserLoginStateObserver observer : observers)
			observer.loggedOut(localUsername, userId);
	}


	@Override
	public void addUserLoginStateObserver(UserLoginStateObserver observer) {
		observers.add(observer);
	}


	@Override
	public void removeUserLoginStateObserver(UserLoginStateObserver observer) {
		if (observers.remove(observer) == false)
			throw new IllegalArgumentException("observer was not added!");
	}

}
