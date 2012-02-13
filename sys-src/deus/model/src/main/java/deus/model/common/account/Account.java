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
package deus.model.common.account;

import java.util.Set;

import deus.model.common.user.id.UserId;

/**
 * A DEUS account of a user. An account is uniquely identified by a
 * <code>localUsername</code>. While the <code>userId</code> also uniquely
 * identifies an account, <code>localUsername</code> is used for loading and
 * storing accounts using DAOs.
 * 
 * The logged in state of the user is stored using <code>loggedIn</code>.
 * 
 * Furthermore, a set of distribution roles, assumed by the account is stored.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class Account {

	// Primary Key: localUsername
	/** The local username. */
	private String localUsername;

	/** The password. */
	private String password;

	/** The user id. */
	private UserId userId;

	// FIXME: think about whether we really want to store logged in state in
	// Account object
	/** The logged in. */
	private boolean loggedIn;

	/** The distribution roles. */
	private final Set<DistributionRole> distributionRoles;

	/**
	 * Instantiates a new account.
	 * 
	 * @param localUsername
	 *            the local username
	 * @param password
	 *            the password
	 * @param userId
	 *            the user id
	 * @param distributionRoles
	 *            the distribution roles
	 */
	public Account(final String localUsername, final String password,
			final UserId userId, final Set<DistributionRole> distributionRoles) {
		super();
		this.localUsername = localUsername;
		this.password = password;
		this.userId = userId;
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
	 * Sets the local username.
	 * 
	 * @param localUsername
	 *            the new local username
	 */
	public void setLocalUsername(final String localUsername) {
		this.localUsername = localUsername;
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
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public UserId getUserId() {
		return this.userId;
	}

	/**
	 * Sets the user id.
	 * 
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(final UserId userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user roles.
	 * 
	 * @return the user roles
	 */
	public Set<DistributionRole> getUserRoles() {
		return this.distributionRoles;
	}

	/**
	 * Checks if is logged in.
	 * 
	 * @return true, if is logged in
	 */
	public boolean isLoggedIn() {
		return this.loggedIn;
	}

	/**
	 * Sets the logged in.
	 * 
	 * @param loggedIn
	 *            the new logged in
	 */
	public void setLoggedIn(final boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
