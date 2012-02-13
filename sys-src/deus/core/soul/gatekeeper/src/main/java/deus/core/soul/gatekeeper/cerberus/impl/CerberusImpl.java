/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
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

/**
 * The Class CerberusImpl.
 */
@Named("cerberus")
public class CerberusImpl implements Cerberus {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(CerberusImpl.class);

	/** The observers. */
	private final List<UserLoginStateObserver> observers;

	/** The login credential checker. */
	@Inject
	private LoginCredentialChecker loginCredentialChecker;

	/** The account dao. */
	@Inject
	private AccountDao accountDao;


	/**
	 * Instantiates a new cerberus impl.
	 */
	public CerberusImpl() {
		super();
		this.observers = new Vector<UserLoginStateObserver>();
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.gatekeeper.cerberus.CerberusExportedToClient#login(deus.model.gatekeeper.LoginCredentials)
	 */
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
	

	/* (non-Javadoc)
	 * @see deus.core.soul.gatekeeper.cerberus.CerberusExportedToClient#logout(java.lang.String)
	 */
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


	/* (non-Javadoc)
	 * @see deus.core.soul.gatekeeper.cerberus.CerberusExportedToSubsystems#addUserLoginStateObserver(deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver)
	 */
	@Override
	public void addUserLoginStateObserver(UserLoginStateObserver observer) {
		observers.add(observer);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.gatekeeper.cerberus.CerberusExportedToSubsystems#removeUserLoginStateObserver(deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver)
	 */
	@Override
	public void removeUserLoginStateObserver(UserLoginStateObserver observer) {
		if (observers.remove(observer) == false)
			throw new IllegalArgumentException("observer was not added!");
	}

}
