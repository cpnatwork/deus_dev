package deus.core.soul.gatekeeper.cerberus.impl;

import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.account.AccountDoRep;
import deus.core.soul.gatekeeper.cerberus.InvalidLoginCredentialsException;
import deus.core.soul.gatekeeper.cerberus.LoginCredentialChecker;
import deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver;
import deus.model.accountadmin.Account;
import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;

@Component("cerberus")
public class CerberusImpl implements Cerberus {

	private final Logger logger = LoggerFactory.getLogger(CerberusImpl.class);

	private final List<UserLoginStateObserver> observers;

	@Autowired
	private LoginCredentialChecker loginCredentialChecker;

	@Autowired
	private AccountDoRep accountDoRep;


	public CerberusImpl() {
		super();
		this.observers = new Vector<UserLoginStateObserver>();
	}


	@Override
	public UserId login(LoginCredentials credentials) {
		if (!loginCredentialChecker.isValid(credentials))
			throw new InvalidLoginCredentialsException(credentials);

		// TODO: do more login stuff, that is necessary
		Account account = accountDoRep.getByNaturalId(credentials.getLocalUsername());
		UserId userId = account.getUserId();
		
		logger.debug("user with id {} logged in", userId);

		account.setLoggedIn(true);
		
		accountDoRep.updateEntity(account);


		// FIXME: implement thread safe notifying (see RegistratorImpl)
		for (UserLoginStateObserver observer : observers)
			observer.loggedIn(userId);
		
		return userId;
	}
	

	@Override
	public void logout(String localUsername) {
		Account account = accountDoRep.getByNaturalId(localUsername);
		UserId userId = account.getUserId();
		
		account.setLoggedIn(false);
		
		accountDoRep.updateEntity(account);


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
