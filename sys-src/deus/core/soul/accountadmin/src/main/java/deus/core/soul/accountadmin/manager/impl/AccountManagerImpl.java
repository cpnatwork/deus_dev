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
package deus.core.soul.accountadmin.manager.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.soul.accountadmin.manager.AccountManager;
import deus.core.soul.accountadmin.rolesetup.DistributionRoleSetup;
import deus.model.common.account.Account;
import deus.model.common.account.DistributionRole;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

/**
 * The Class AccountManagerImpl.
 */
@Named("accountManager")
public class AccountManagerImpl implements AccountManager {

	/** The account dao. */
	@Inject
	private AccountDao accountDao;

	/** The user metadata dao. */
	@Inject
	private UserMetadataDao userMetadataDao;

	/** The distribution role setup. */
	@Inject
	private DistributionRoleSetup distributionRoleSetup;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.manager.AccountManager#changePassword(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public void changePassword(final String localUsername,
			final String newPassword) {
		final Account account = this.accountDao.getByNaturalId(localUsername);

		account.setPassword(newPassword);

		this.accountDao.updateEntity(account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.manager.AccountManager#addRole(java.lang.
	 * String, deus.model.common.account.DistributionRole)
	 */
	@Override
	public void addRole(final String localUsername,
			final DistributionRole distributionRole) {
		final Account account = this.accountDao.getByNaturalId(localUsername);

		if (account.getUserRoles().add(distributionRole) == false)
			throw new IllegalArgumentException("account " + account
					+ " already contains role " + distributionRole);

		this.accountDao.updateEntity(account);

		this.distributionRoleSetup.setUpRole(distributionRole,
				account.getUserId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.manager.AccountManager#removeRole(java.lang
	 * .String, deus.model.common.account.DistributionRole)
	 */
	@Override
	public void removeRole(final String localUsername,
			final DistributionRole distributionRole) {
		final Account account = this.accountDao.getByNaturalId(localUsername);

		if (!account.getUserRoles().contains(distributionRole))
			throw new IllegalArgumentException("account " + account
					+ " does not contain role " + distributionRole);

		account.getUserRoles().remove(distributionRole);

		this.accountDao.updateEntity(account);

		this.distributionRoleSetup.tearDownRole(distributionRole,
				account.getUserId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.manager.AccountManager#changeUserMetadata
	 * (java.lang.String, deus.model.common.user.UserMetadata)
	 */
	@Override
	public void changeUserMetadata(final String localUsername,
			final UserMetadata userMetadata) {
		final Account account = this.accountDao.getByNaturalId(localUsername);

		final UserId userId = account.getUserId();

		this.userMetadataDao.updateEntity(userId, userMetadata);
	}

}
