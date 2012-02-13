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

import static org.junit.Assert.*;

import org.easymock.classextension.EasyMock;
import org.junit.Test;

import deus.model.common.account.Account;
import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;

/**
 * The Class CerberusExportedToClientTest.
 */
public class CerberusExportedToClientTest extends AbstractCerberusTest {
	
	/** The login credentials fix. */
	private LoginCredentials loginCredentialsFix;
	
	/** The account fix. */
	private Account accountFix;
	
	/** The user id fix. */
	private UserId userIdFix;

	/* (non-Javadoc)
	 * @see deus.common.DeusUnitTestCaseEasyMockTemplate#getFixtureMocks()
	 */
	@Override
	protected Object[] getFixtureMocks() {
		return new Object[] {loginCredentialsFix, accountFix, userIdFix};
	}


	/* (non-Javadoc)
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpFixture()
	 */
	@Override
	protected void setUpFixture() {
		loginCredentialsFix = EasyMock.createMock(LoginCredentials.class);
		accountFix = EasyMock.createMock(Account.class);
		userIdFix = EasyMock.createMock(UserId.class);
	}

	
	/**
	 * Login test_ happy path.
	 */
	@Test
	public void loginTest_HappyPath() {
		// PREPARATION
		
		// credentials should be valid in this case
		EasyMock.expect(loginCredentialCheckerMock.isValid(loginCredentialsFix)).andReturn(true);
		
		String testUserName = "testUserName";
		EasyMock.expect(loginCredentialsFix.getLocalUsername()).andReturn(testUserName);
		
		EasyMock.expect(accountDaoMock.getByNaturalId(testUserName)).andReturn(accountFix);
		accountDaoMock.updateEntity(accountFix);
		
		accountFix.setLoggedIn(true);
		EasyMock.expect(accountFix.getUserId()).andReturn(userIdFix);
		
		replayAllMocks();
		
		
		// TEST
		assertEquals(userIdFix, cerberus.login(loginCredentialsFix));

		
		// CHECK
		verifyAllMocks();
	}
	
	
	/**
	 * Login test_ wrong login credentials.
	 */
	@Test
	public void loginTest_WrongLoginCredentials() {
		// PREPARATION
		
		// credentials should be wrong in this case
		EasyMock.expect(loginCredentialCheckerMock.isValid(loginCredentialsFix)).andReturn(false);
		
		replayAllMocks();
		
		
		// TEST
		try {
			cerberus.login(loginCredentialsFix);
			fail("wrong login credentials are accepted");
		}
		catch (InvalidLoginCredentialsException e) {
			// expected
		}
		
		// CHECK
		verifyAllMocks();
	}
	
	
		
	
	/**
	 * Logout test.
	 */
	@Test
	public void logoutTest() {
		// PREPARATION
		
		String testUserName = "testUserName";

		EasyMock.expect(accountDaoMock.getByNaturalId(testUserName)).andReturn(accountFix);
		accountDaoMock.updateEntity(accountFix);
		
		accountFix.setLoggedIn(false);
		EasyMock.expect(accountFix.getUserId()).andReturn(userIdFix);
		
		replayAllMocks();
		
		
		// TEST
		cerberus.logout(testUserName);

		
		// CHECK
		verifyAllMocks();
	}
	
	
}
