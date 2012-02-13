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
package deus.model.gatekeeper;

/**
 * The Class LoginCredentials.
 */
public class LoginCredentials {

	/** The local username. */
	private final String localUsername;

	/** The password. */
	private final String password;

	/**
	 * Instantiates a new login credentials.
	 * 
	 * @param localUsername
	 *            the local username
	 * @param password
	 *            the password
	 */
	public LoginCredentials(final String localUsername, final String password) {
		super();
		this.localUsername = localUsername;
		this.password = password;
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

}
