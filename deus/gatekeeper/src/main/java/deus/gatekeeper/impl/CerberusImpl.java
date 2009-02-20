package deus.gatekeeper.impl;

import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.user.api.LocalUserDao;
import deus.gatekeeper.Cerberus;
import deus.gatekeeper.LoginCredentialChecker;
import deus.gatekeeper.UserLoginStateObserver;
import deus.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;

@Component("cerberus")
public class CerberusImpl implements Cerberus {

	private final Logger logger = LoggerFactory.getLogger(CerberusImpl.class);
	
	private final List<UserLoginStateObserver> observers;

	@Autowired
	private LoginCredentialChecker loginCredentialChecker;

	@Autowired
	private LocalUserDao localUserDao;


	public CerberusImpl() {
		super();
		this.observers = new Vector<UserLoginStateObserver>();
	}


	@Override
	public void login(LoginCredentials credentials) {
		if (!loginCredentialChecker.isValid(credentials))
			// FIXME: think about what to do here
			;

		// TODO: do more login stuff, that is necessary
		UserId userId = localUserDao.getByNaturalId(credentials.getLocalUsername());
		
		logger.debug("user with id {} logged in", userId);

		for (UserLoginStateObserver observer : observers)
			observer.loggedIn(userId);
	}


	@Override
	public void logout(String localUsername) {
		UserId userId = localUserDao.getByNaturalId(localUsername);

		logger.debug("user with id {} logged out", userId);
		
		for (UserLoginStateObserver observer : observers)
			observer.loggedOut(userId);
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
