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

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;

/**
 * The Class CerberusExportedToSubsystemsTest.
 */
public class CerberusExportedToSubsystemsTest extends AbstractCerberusTest {

	/** The logged in. */
	private int loggedIn;

	/** The logged out. */
	private int loggedOut;

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseEasyMockTemplate#getFixtureMocks()
	 */
	@Override
	protected Object[] getFixtureMocks() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpFixture()
	 */
	@Override
	protected void setUpFixture() {
		this.loggedIn = 0;
		this.loggedOut = 0;
	}

	// TODO: remove
	/**
	 * Test stub.
	 */
	@Test
	public void testStub() {
	}

	// FIXME: think about this test method...
	// @Test
	/**
	 * Test login logout.
	 */
	public void testLoginLogout() {
		final LoginCredentials credentials = new LoginCredentials("alice",
				"password");

		EasyMock.expect(this.loginCredentialCheckerMock.isValid(credentials))
				.andStubReturn(true);

		this.replayAllMocks();

		final UserLoginStateObserver obs = new UserLoginStateObserver() {

			@Override
			public void loggedIn(final UserId userId) {
				CerberusExportedToSubsystemsTest.this.loggedIn++;
			}

			@Override
			public void loggedOut(final UserId userId) {
				CerberusExportedToSubsystemsTest.this.loggedOut++;
			}

		};

		this.cerberus.addUserLoginStateObserver(obs);

		Assert.assertEquals(0, this.loggedIn);
		Assert.assertEquals(0, this.loggedOut);
		// LOGIN
		this.cerberus.login(credentials);
		Assert.assertEquals(1, this.loggedIn);
		Assert.assertEquals(0, this.loggedOut);

		// LOGOUT
		this.cerberus.logout(credentials.getLocalUsername());

		Assert.assertEquals(1, this.loggedIn);
		Assert.assertEquals(1, this.loggedOut);

		this.cerberus.removeUserLoginStateObserver(obs);

		this.cerberus.login(credentials);
		this.cerberus.logout(credentials.getLocalUsername());
		Assert.assertEquals(1, this.loggedIn);
		Assert.assertEquals(1, this.loggedOut);
	}
}
