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
package deus.core.soul.gatekeeper.cerberus;

import deus.model.gatekeeper.LoginCredentials;

/**
 * The Class InvalidLoginCredentialsException.
 */
public class InvalidLoginCredentialsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8101222420761567833L;

	/** The login credentials. */
	private final LoginCredentials loginCredentials;

	/**
	 * Instantiates a new invalid login credentials exception.
	 * 
	 * @param loginCredentials
	 *            the login credentials
	 */
	public InvalidLoginCredentialsException(
			final LoginCredentials loginCredentials) {
		super();
		this.loginCredentials = loginCredentials;
	}

	/**
	 * Gets the login credentials.
	 * 
	 * @return the login credentials
	 */
	public LoginCredentials getLoginCredentials() {
		return this.loginCredentials;
	}

}
