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

import deus.model.common.user.id.UserId;

/**
 * An asynchronous update interface for receiving notifications about
 * UserLoginState information as the UserLoginState is constructed.
 */
public interface UserLoginStateObserver {

	/**
	 * This method is called when information about an UserLoginState which was
	 * previously requested using an asynchronous interface becomes available.
	 * 
	 * @param userId
	 *            the user id
	 */
	public void loggedIn(UserId userId);

	/**
	 * This method is called when information about an UserLoginState which was
	 * previously requested using an asynchronous interface becomes available.
	 * 
	 * @param userId
	 *            the user id
	 */
	public void loggedOut(UserId userId);

}
