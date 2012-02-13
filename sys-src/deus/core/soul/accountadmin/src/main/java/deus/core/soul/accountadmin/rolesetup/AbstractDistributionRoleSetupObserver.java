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
package deus.core.soul.accountadmin.rolesetup;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

/**
 * An asynchronous update interface for receiving notifications about
 * AbstractDistributionRoleSetup information as the
 * AbstractDistributionRoleSetup is constructed.
 */
public abstract class AbstractDistributionRoleSetupObserver implements
		DistributionRoleSetupObserver {

	/** The distribution role setup. */
	@Inject
	private DistributionRoleSetup distributionRoleSetup;

	/**
	 * This method is called when information about an
	 * AbstractDistributionRoleSetup which was previously requested using an
	 * asynchronous interface becomes available.
	 */
	@PostConstruct
	@SuppressWarnings("unused")
	private void addObserver() {
		this.distributionRoleSetup.addRoleSetupObserver(
				this.getDistributionRole(), this);
	}

	/**
	 * This method is called when information about an
	 * AbstractDistributionRoleSetup which was previously requested using an
	 * asynchronous interface becomes available.
	 */
	@PreDestroy
	@SuppressWarnings("unused")
	private void removeObserver() {
		this.distributionRoleSetup.removeRoleSetupObserver(
				this.getDistributionRole(), this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.rolesetup.DistributionRoleSetupObserver#setUpRole
	 * (deus.model.common.account.DistributionRole,
	 * deus.model.common.user.id.UserId)
	 */
	@Override
	public void setUpRole(final DistributionRole distributionRole,
			final UserId userId) {
		if (!distributionRole.equals(this.getDistributionRole()))
			throw new RuntimeException(
					"received notification for set up of user role "
							+ distributionRole
							+ " while only listening for set up of role "
							+ this.getDistributionRole());
		this.setUpRole(userId);
	}

	/**
	 * This method is called when information about an
	 * AbstractDistributionRoleSetup which was previously requested using an
	 * asynchronous interface becomes available.
	 * 
	 * @param userId
	 *            the user id
	 */
	protected abstract void setUpRole(UserId userId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.accountadmin.rolesetup.DistributionRoleSetupObserver#
	 * tearDownRole(deus.model.common.account.DistributionRole,
	 * deus.model.common.user.id.UserId)
	 */
	@Override
	public void tearDownRole(final DistributionRole distributionRole,
			final UserId userId) {
		if (!distributionRole.equals(this.getDistributionRole()))
			throw new RuntimeException(
					"received notification for tear down of user role "
							+ distributionRole
							+ " while only listening for tear down of role "
							+ this.getDistributionRole());

		this.tearDownRole(userId);
	}

	/**
	 * This method is called when information about an
	 * AbstractDistributionRoleSetup which was previously requested using an
	 * asynchronous interface becomes available.
	 * 
	 * @param userId
	 *            the user id
	 */
	protected abstract void tearDownRole(UserId userId);

	/**
	 * Returns the distribution role, this observer should setup.
	 * 
	 * @return the distribution role
	 */
	protected abstract DistributionRole getDistributionRole();

}