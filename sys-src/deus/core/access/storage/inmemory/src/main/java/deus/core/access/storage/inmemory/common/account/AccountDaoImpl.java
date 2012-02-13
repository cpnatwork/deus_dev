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
package deus.core.access.storage.inmemory.common.account;

import javax.inject.Named;

import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.account.Account;

/**
 * The Class AccountDaoImpl.
 * 
 * @author cpn
 */
@Named("accountDao")
public class AccountDaoImpl extends GenericVanillaDaoImpl<Account, String> implements AccountDao {

	/* (non-Javadoc)
	 * @see deus.core.access.storage.api.common.account.AccountDao#addNewEntity(deus.model.common.account.Account)
	 */
	@Override
	public void addNewEntity(Account account) {
		addNewEntity(account.getLocalUsername(), account);
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.api.common.account.AccountDao#updateEntity(deus.model.common.account.Account)
	 */
	@Override
	public void updateEntity(Account account) {
		updateEntity(account.getLocalUsername(), account);
	}

}
