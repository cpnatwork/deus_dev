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
package deus.core.soul.gatekeeper.cerberus.prep;

import deus.model.gatekeeper.LoginCredentials;

// TODO: implement again
/**
 * The Class LoginCredentialsValidator.
 */
public class LoginCredentialsValidator { // implements Validator {

	/** The login credentials. */
	LoginCredentials loginCredentials;

	/**
	 * Supports.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return true, if successful
	 */
	public boolean supports(final Class clazz) {
		return LoginCredentials.class.isAssignableFrom(clazz);
	}

	// public void validate(Object commandObject, Errors errors) {
	//
	// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
	// "Field is required.");
	// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
	// "Field is required.");
	//
	// loginCredentials = (LoginCredentials) commandObject;
	//
	// if ((loginCredentials.getPassword() != "password")
	// && (loginCredentials.getLocalUsername() != "partha")) {
	// errors.reject("Credentials provided are not correct.");
	// }
	// }
}
