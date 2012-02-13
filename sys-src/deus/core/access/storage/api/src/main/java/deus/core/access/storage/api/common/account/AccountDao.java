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
package deus.core.access.storage.api.common.account;

import deus.model.common.account.Account;

/**
 * The Interface AccountDao.
 */
public interface AccountDao {

	/**
	 * Gets the by natural id.
	 * 
	 * @param localUsername
	 *            the local username
	 * @return the by natural id
	 */
	public Account getByNaturalId(String localUsername);

	/**
	 * Update entity.
	 * 
	 * @param account
	 *            the account
	 */
	public void updateEntity(Account account);

	/**
	 * Delete by natural id.
	 * 
	 * @param localUsername
	 *            the local username
	 */
	public void deleteByNaturalId(String localUsername);

	/**
	 * Exists by natural id.
	 * 
	 * @param localUserName
	 *            the local user name
	 * @return true, if successful
	 */
	public boolean existsByNaturalId(String localUserName);

	/**
	 * Adds the new entity.
	 * 
	 * @param account
	 *            the account
	 */
	public void addNewEntity(Account account);

}
