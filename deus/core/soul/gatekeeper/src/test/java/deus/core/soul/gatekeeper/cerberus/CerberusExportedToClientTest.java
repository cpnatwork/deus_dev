package deus.core.soul.gatekeeper.cerberus;

import static org.junit.Assert.*;

import org.easymock.classextension.EasyMock;
import org.junit.Test;

import deus.model.common.account.Account;
import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;

public class CerberusExportedToClientTest extends AbstractCerberusTest {
	
	private LoginCredentials loginCredentialsFix;
	private Account accountFix;
	private UserId userIdFix;

	@Override
	protected Object[] getFixtureMocks() {
		return new Object[] {loginCredentialsFix, accountFix, userIdFix};
	}


	@Override
	protected void setUpFixture() {
		loginCredentialsFix = EasyMock.createMock(LoginCredentials.class);
		accountFix = EasyMock.createMock(Account.class);
		userIdFix = EasyMock.createMock(UserId.class);
	}

	
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
