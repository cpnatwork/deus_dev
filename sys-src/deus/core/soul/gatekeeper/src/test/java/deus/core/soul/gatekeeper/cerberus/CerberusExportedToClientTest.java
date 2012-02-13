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
import org.junit.Assert;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseEasyMockTemplate#getFixtureMocks()
	 */
	@Override
	protected Object[] getFixtureMocks() {
		return new Object[] { this.loginCredentialsFix, this.accountFix,
				this.userIdFix };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpFixture()
	 */
	@Override
	protected void setUpFixture() {
		this.loginCredentialsFix = EasyMock.createMock(LoginCredentials.class);
		this.accountFix = EasyMock.createMock(Account.class);
		this.userIdFix = EasyMock.createMock(UserId.class);
	}

	/**
	 * Login test_ happy path.
	 */
	@Test
	public void loginTest_HappyPath() {
		// PREPARATION

		// credentials should be valid in this case
		org.easymock.EasyMock.expect(
				this.loginCredentialCheckerMock
						.isValid(this.loginCredentialsFix)).andReturn(true);

		final String testUserName = "testUserName";
		org.easymock.EasyMock.expect(
				this.loginCredentialsFix.getLocalUsername()).andReturn(
				testUserName);

		org.easymock.EasyMock.expect(
				this.accountDaoMock.getByNaturalId(testUserName)).andReturn(
				this.accountFix);
		this.accountDaoMock.updateEntity(this.accountFix);

		this.accountFix.setLoggedIn(true);
		org.easymock.EasyMock.expect(this.accountFix.getUserId()).andReturn(
				this.userIdFix);

		this.replayAllMocks();

		// TEST
		Assert.assertEquals(this.userIdFix,
				this.cerberus.login(this.loginCredentialsFix));

		// CHECK
		this.verifyAllMocks();
	}

	/**
	 * Login test_ wrong login credentials.
	 */
	@Test
	public void loginTest_WrongLoginCredentials() {
		// PREPARATION

		// credentials should be wrong in this case
		org.easymock.EasyMock.expect(
				this.loginCredentialCheckerMock
						.isValid(this.loginCredentialsFix)).andReturn(false);

		this.replayAllMocks();

		// TEST
		try {
			this.cerberus.login(this.loginCredentialsFix);
			Assert.fail("wrong login credentials are accepted");
		} catch (final InvalidLoginCredentialsException e) {
			// expected
		}

		// CHECK
		this.verifyAllMocks();
	}

	/**
	 * Logout test.
	 */
	@Test
	public void logoutTest() {
		// PREPARATION

		final String testUserName = "testUserName";

		org.easymock.EasyMock.expect(
				this.accountDaoMock.getByNaturalId(testUserName)).andReturn(
				this.accountFix);
		this.accountDaoMock.updateEntity(this.accountFix);

		this.accountFix.setLoggedIn(false);
		org.easymock.EasyMock.expect(this.accountFix.getUserId()).andReturn(
				this.userIdFix);

		this.replayAllMocks();

		// TEST
		this.cerberus.logout(testUserName);

		// CHECK
		this.verifyAllMocks();
	}

}
