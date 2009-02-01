package deus.core.gatekeeper.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.gatekeeper.Gatekeeper;
import deus.gatekeeper.UserLoginStateObserver;
import deus.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml" , "/deus/storage/daos.xml" })
public class GatekeeperImplTest {

	@Autowired
	private Gatekeeper gatekeeper;


	private int loggedIn;
	
	private int loggedOut;
	
	
	@Before
	public void setUp() {
		loggedIn = 0;
		loggedOut = 0;
	}
	
	
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
		
		gatekeeper.addUserLoginStateObserver(obs);
		
		assertEquals(0, loggedIn);
		assertEquals(0, loggedOut);
		// LOGIN
		gatekeeper.login(credentials);
		assertEquals(1, loggedIn);
		assertEquals(0, loggedOut);
		
		// LOGOUT
		gatekeeper.logout(credentials.getLocalUsername());
		
		assertEquals(1, loggedIn);
		assertEquals(1, loggedOut);
		
		gatekeeper.removeUserLoginStateObserver(obs);
		
		gatekeeper.login(credentials);
		gatekeeper.logout(credentials.getLocalUsername());
		assertEquals(1, loggedIn);
		assertEquals(1, loggedOut);		
	}

}
