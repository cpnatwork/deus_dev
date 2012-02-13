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
package deus.core.soul.accountadmin.manager;

import deus.model.common.account.DistributionRole;
import deus.model.common.user.UserMetadata;

/**
 * The Interface AccountManager.
 */
public interface AccountManager {

	/**
	 * Change password.
	 * 
	 * @param localUsername
	 *            the local username
	 * @param newPassword
	 *            the new password
	 */
	public void changePassword(String localUsername, String newPassword);

	/**
	 * Change user metadata.
	 * 
	 * @param localUsername
	 *            the local username
	 * @param userMetadata
	 *            the user metadata
	 */
	public void changeUserMetadata(String localUsername,
			UserMetadata userMetadata);

	/**
	 * Adds the role.
	 * 
	 * @param localUsername
	 *            the local username
	 * @param distributionRole
	 *            the distribution role
	 */
	public void addRole(String localUsername, DistributionRole distributionRole);

	/**
	 * Removes the role.
	 * 
	 * @param localUsername
	 *            the local username
	 * @param distributionRole
	 *            the distribution role
	 */
	public void removeRole(String localUsername,
			DistributionRole distributionRole);

}
