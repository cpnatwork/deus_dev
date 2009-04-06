package deus.core.soul.gatekeeper.cerberus.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver;
import deus.core.soul.gatekeeper.cerberus.impl.Cerberus;
import deus.model.gatekeeper.LoginCredentials;
import deus.model.user.id.UserId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml" , "/deus/storage/daos.xml", "/deus/gatekeeper/gatekeeper.xml" })
public class CerberusImplTest {

	@Autowired
	private Cerberus cerberus;


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
