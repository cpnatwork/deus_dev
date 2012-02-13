package deus.core.soul.gatekeeper.cerberus.impl;

import java.util.List;
import java.util.Vector;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.soul.gatekeeper.cerberus.InvalidLoginCredentialsException;
import deus.core.soul.gatekeeper.cerberus.LoginCredentialChecker;
import deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver;
import deus.model.common.account.Account;
import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;

@Named("cerberus")
public class CerberusImpl implements Cerberus {

	private final Logger logger = LoggerFactory.getLogger(CerberusImpl.class);

	private final List<UserLoginStateObserver> observers;

	@Inject
	private LoginCredentialChecker loginCredentialChecker;

	@Inject
	private AccountDao accountDao;


	public CerberusImpl() {
		super();
		this.observers = new Vector<UserLoginStateObserver>();
	}


	@Override
	public UserId login(LoginCredentials credentials) {
		if (!loginCredentialChecker.isValid(credentials))
			throw new InvalidLoginCredentialsException(credentials);

		// TODO: do more login stuff, that is necessary
		Account account = accountDao.getByNaturalId(credentials.getLocalUsername());
		UserId userId = account.getUserId();
		
		logger.debug("user with id {} logged in", userId);

		account.setLoggedIn(true);
		
		accountDao.updateEntity(account);


		// FIXME: implement thread safe notifying (see RegistratorImpl)
		for (UserLoginStateObserver observer : observers)
			observer.loggedIn(userId);
		
		return userId;
	}
	

	@Override
	public void logout(String localUsername) {
		Account account = accountDao.getByNaturalId(localUsername);
		UserId userId = account.getUserId();
		
		account.setLoggedIn(false);
		
		accountDao.updateEntity(account);


		logger.debug("user with id {} logged out", userId);

		// FIXME: implement thread safe notifying (see RegistratorImpl)
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
