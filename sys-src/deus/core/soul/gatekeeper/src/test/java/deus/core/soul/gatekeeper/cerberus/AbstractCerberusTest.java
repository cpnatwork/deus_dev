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

import org.easymock.classextension.EasyMock;
import org.springframework.test.util.ReflectionTestUtils;

import deus.common.DeusUnitTestCaseEasyMockTemplate;
import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.soul.gatekeeper.cerberus.impl.Cerberus;
import deus.core.soul.gatekeeper.cerberus.impl.CerberusImpl;

/**
 * The Class AbstractCerberusTest.
 */
public abstract class AbstractCerberusTest extends DeusUnitTestCaseEasyMockTemplate {

	/** The login credential checker mock. */
	protected LoginCredentialChecker loginCredentialCheckerMock;
	
	/** The account dao mock. */
	protected AccountDao accountDaoMock;

	
	/* (non-Javadoc)
	 * @see deus.common.DeusUnitTestCaseEasyMockTemplate#getDependencyMocks()
	 */
	@Override
	protected Object[] getDependencyMocks() {
		return new Object[] {loginCredentialCheckerMock, accountDaoMock};
	}


	/* (non-Javadoc)
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpDependencies()
	 */
	@Override
	protected void setUpDependencies() {
		loginCredentialCheckerMock = EasyMock.createMock(LoginCredentialChecker.class);
		accountDaoMock = EasyMock.createMock(AccountDao.class);
	}

	
	/** The cerberus. */
	protected Cerberus cerberus;

	/* (non-Javadoc)
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpSUT()
	 */
	@Override
	protected void setUpSUT() {
		cerberus = new CerberusImpl();
		ReflectionTestUtils.setField(cerberus, "accountDao", accountDaoMock);
		ReflectionTestUtils.setField(cerberus, "loginCredentialChecker", loginCredentialCheckerMock);
	}


	/* (non-Javadoc)
	 * @see deus.common.DeusUnitTestCaseTemplate#tearDownSUT()
	 */
	@Override
	protected void tearDownSUT() {
		cerberus = null;
	}

}
