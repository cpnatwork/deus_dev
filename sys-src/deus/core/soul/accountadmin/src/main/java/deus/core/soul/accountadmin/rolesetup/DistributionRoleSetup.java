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

import deus.model.common.account.DistributionRole;
import deus.model.common.user.id.UserId;

/**
 * The Interface DistributionRoleSetup.
 */
public interface DistributionRoleSetup {

	/**
	 * Sets the up role.
	 * 
	 * @param distributionRole
	 *            the distribution role
	 * @param userId
	 *            the user id
	 */
	public void setUpRole(DistributionRole distributionRole, UserId userId);

	/**
	 * Tear down role.
	 * 
	 * @param distributionRole
	 *            the distribution role
	 * @param userId
	 *            the user id
	 */
	public void tearDownRole(DistributionRole distributionRole, UserId userId);

	/**
	 * Adds the role setup observer.
	 * 
	 * @param distributionRole
	 *            the distribution role
	 * @param observer
	 *            the observer
	 */
	public void addRoleSetupObserver(DistributionRole distributionRole,
			DistributionRoleSetupObserver observer);

	/**
	 * Removes the role setup observer.
	 * 
	 * @param distributionRole
	 *            the distribution role
	 * @param observer
	 *            the observer
	 */
	public void removeRoleSetupObserver(DistributionRole distributionRole,
			DistributionRoleSetupObserver observer);
}
