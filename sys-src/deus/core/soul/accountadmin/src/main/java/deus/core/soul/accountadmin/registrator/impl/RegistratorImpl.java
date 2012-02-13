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
package deus.core.soul.accountadmin.registrator.impl;

import java.util.List;
import java.util.Vector;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.soul.accountadmin.registrator.UserIdGenerator;
import deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver;
import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup;
import deus.model.accountadmin.RegistrationInformation;
import deus.model.common.account.Account;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

/**
 * The Class RegistratorImpl.
 */
@Named("registrator")
public class RegistratorImpl implements Registrator {

	/** The observers. */
	private final List<UserRegistrationStateObserver> observers;

	/** The account dao. */
	@Inject
	private AccountDao accountDao;

	/** The user metadata dao. */
	@Inject
	private UserMetadataDao userMetadataDao;

	/** The distribution role setup. */
	@Inject
	private DistributionRoleSetup distributionRoleSetup;

	/** The user id generator. */
	@Inject
	private UserIdGenerator userIdGenerator;

	/**
	 * Instantiates a new registrator impl.
	 */
	public RegistratorImpl() {
		this.observers = new Vector<UserRegistrationStateObserver>();
	}

	/**
	 * Notify observers.
	 * 
	 * @param userId
	 *            the user id
	 * @param registered
	 *            the registered
	 */
	private void notifyObservers(final UserId userId, final boolean registered) {
		/*
		 * a temporary array buffer, used as a snapshot of the state of current
		 * Observers.
		 */
		Object[] arrLocal;

		synchronized (this) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code
			 * while holding its own Monitor. The code where we extract each
			 * Observable from the Vector and store the state of the Observer
			 * needs synchronization, but notifying observers does not (should
			 * not). The worst result of any potential race-condition here is
			 * that: 1) a newly-added Observer will miss a notification in
			 * progress 2) a recently unregistered Observer will be wrongly
			 * notified when it doesn't care
			 */
			arrLocal = this.observers.toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			final UserRegistrationStateObserver observer = (UserRegistrationStateObserver) arrLocal[i];

			if (registered) {
				observer.registered(userId);
			} else {
				observer.unregistered(userId);
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.registrator.RegistratorExportedToClient#register
	 * (deus.model.accountadmin.RegistrationInformation)
	 */
	@Override
	public void register(final RegistrationInformation registrationInformation) {
		final UserId userId = this.userIdGenerator.generateUserId(
				registrationInformation.getDesiredUserIdType(),
				registrationInformation.getLocalUsername());

		final Account account = new Account(
				registrationInformation.getLocalUsername(),
				registrationInformation.getPassword(), userId,
				registrationInformation.getUserRoles());

		this.userMetadataDao.addNewEntity(userId,
				registrationInformation.getUserMetadata());

		this.createAccount(account);

		this.notifyObservers(userId, true);
	}

	/**
	 * Creates the account.
	 * 
	 * @param account
	 *            the account
	 */
	private void createAccount(final Account account) {
		this.accountDao.addNewEntity(account);
		// FUTURE: init data objects in database for subsystem Barker here!

		// INITIALIZING ROLE DATA ELEMENTS
		for (final DistributionRole distributionRole : account.getUserRoles()) {
			this.distributionRoleSetup.setUpRole(distributionRole,
					account.getUserId());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.accountadmin.registrator.RegistratorExportedToClient#
	 * unregister(java.lang.String)
	 */
	@Override
	public void unregister(final String localUsername) {
		final Account account = this.accountDao.getByNaturalId(localUsername);

		this.destroyAccount(account);

		this.notifyObservers(account.getUserId(), false);
	}

	/**
	 * Destroy account.
	 * 
	 * @param account
	 *            the account
	 */
	private void destroyAccount(final Account account) {
		final UserId userId = account.getUserId();

		this.accountDao.deleteByNaturalId(account.getLocalUsername());
		// FUTURE: destroy data objects in database for subsystem Barker here!

		// DESTROYING ROLE DATA ELEMENTS
		for (final DistributionRole distributionRole : account.getUserRoles()) {
			this.distributionRoleSetup.tearDownRole(distributionRole, userId);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.accountadmin.registrator.RegistratorExportedToClient#
	 * existsLocalUsername(java.lang.String)
	 */
	@Override
	public boolean existsLocalUsername(final String localUserName) {
		return this.accountDao.existsByNaturalId(localUserName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.registrator.RegistratorExportedToSubsystems
	 * #addUserRegistrationStateObserver
	 * (deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver)
	 */
	@Override
	public void addUserRegistrationStateObserver(
			final UserRegistrationStateObserver observer) {
		this.observers.add(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.registrator.RegistratorExportedToSubsystems
	 * #removeUserRegistrationStateObserver
	 * (deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver)
	 */
	@Override
	public void removeUserRegistrationStateObserver(
			final UserRegistrationStateObserver observer) {
		if (this.observers.remove(observer) == false)
			throw new IllegalArgumentException("observer was not added!");
	}

}
