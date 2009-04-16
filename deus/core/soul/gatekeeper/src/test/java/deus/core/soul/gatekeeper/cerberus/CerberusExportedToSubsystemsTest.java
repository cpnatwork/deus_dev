package deus.core.soul.gatekeeper.cerberus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver;
import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;

public class CerberusExportedToSubsystemsTest extends AbstractCerberusTest {
	
	private int loggedIn;
	
	private int loggedOut;
	
	@Override
	protected Object[] getFixtureMocks() {
		return null;
	}


	@Override
	protected void setUpFixture() {
		loggedIn = 0;
		loggedOut = 0;
	}

	
		
	// FIXME: think about this test method...
	@Test
	public void testLoginLogout() {
		LoginCredentials credentials = new LoginCredentials("alice", "password");

		UserLoginStateObserver obs = new UserLoginStateObserver() {

			@Override
			public void loggedIn(UserId userId) {
				loggedIn++;
			}

			@Override
			public void loggedOut(UserId userId) {
				loggedOut++;
			}
			
		};
		
		cerberus.addUserLoginStateObserver(obs);
		
		assertEquals(0, loggedIn);
		assertEquals(0, loggedOut);
		// LOGIN
		cerberus.login(credentials);
		assertEquals(1, loggedIn);
		assertEquals(0, loggedOut);
		
		// LOGOUT
		cerberus.logout(credentials.getLocalUsername());
		
		assertEquals(1, loggedIn);
		assertEquals(1, loggedOut);
		
		cerberus.removeUserLoginStateObserver(obs);
		
		cerberus.login(credentials);
		cerberus.logout(credentials.getLocalUsername());
		assertEquals(1, loggedIn);
		assertEquals(1, loggedOut);		
	}
}
