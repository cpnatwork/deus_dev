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
package deus.model.accountadmin;

import java.util.Set;

import deus.model.common.account.DistributionRole;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserIdType;

/**
 * The Class RegistrationInformation.
 */
public class RegistrationInformation {

	/** The local username. */
	private final String localUsername;

	/** The password. */
	private final String password;

	/** The user metadata. */
	private final UserMetadata userMetadata;

	/** The desired user id type. */
	private final UserIdType desiredUserIdType;

	/** The distribution roles. */
	private final Set<DistributionRole> distributionRoles;

	/**
	 * Instantiates a new registration information.
	 * 
	 * @param localUsername
	 *            the local username
	 * @param password
	 *            the password
	 * @param userMetadata
	 *            the user metadata
	 * @param desiredUserIdType
	 *            the desired user id type
	 * @param distributionRoles
	 *            the distribution roles
	 */
	public RegistrationInformation(final String localUsername,
			final String password, final UserMetadata userMetadata,
			final UserIdType desiredUserIdType,
			final Set<DistributionRole> distributionRoles) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.userMetadata = userMetadata;
		this.desiredUserIdType = desiredUserIdType;
		this.distributionRoles = distributionRoles;
	}

	/**
	 * Gets the local username.
	 * 
	 * @return the local username
	 */
	public String getLocalUsername() {
		return this.localUsername;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the user metadata.
	 * 
	 * @return the user metadata
	 */
	public UserMetadata getUserMetadata() {
		return this.userMetadata;
	}

	/**
	 * Gets the desired user id type.
	 * 
	 * @return the desired user id type
	 */
	public UserIdType getDesiredUserIdType() {
		return this.desiredUserIdType;
	}

	/**
	 * Gets the user roles.
	 * 
	 * @return the user roles
	 */
	public Set<DistributionRole> getUserRoles() {
		return this.distributionRoles;
	}

}
