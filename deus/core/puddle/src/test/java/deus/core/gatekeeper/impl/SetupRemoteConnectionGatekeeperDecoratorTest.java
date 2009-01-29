package deus.core.gatekeeper.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.gatekeeper.Gatekeeper;
import deus.core.soul.gatekeeper.soul.LoginCredentials;
import deus.core.transport.state.RemotingState;
import deus.core.transport.state.RemotingStateRegistry;
import deus.model.user.id.UserUrl;
import deus.model.user.transportid.TransportIdType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/core.xml", "/deus/core/core-test.xml" })
public class SetupRemoteConnectionGatekeeperDecoratorTest {

	@Autowired
	private UserRegistry userRegistry;


	@Resource(name = "gatekeeper")
	private Gatekeeper gatekeeper;


	@Before
	public void setUp() throws Exception {

	}


	@Test
	public void testLogin() {
		LoginCredentials credentials = new LoginCredentials("alice", "password");
		gatekeeper.login(credentials);
		assertTrue(userRegistry.hasUser(credentials.getLocalUsername()));
		User user = userRegistry.getUser(credentials.getLocalUsername());

		RemotingStateRegistry registry = user.getRemotingStateRegistry();
		assertTrue(user.getUserId().hasTransportId(TransportIdType.local));
		for (TransportIdType type : user.getUserId().getSupportedTransports()) {
			System.out.println("testing added remoting state for transport protocol '" + type + "'");
			RemotingState remotingState = registry.getRemotingState(type);
			assertNotNull(remotingState);
			assertEquals(type, remotingState.getType());
		}

		gatekeeper.logout(credentials.getLocalUsername());
		assertFalse(userRegistry.hasUser(credentials.getLocalUsername()));

		for (TransportIdType type : user.getUserId().getSupportedTransports()) {
			System.out.println("testing removed remoting state for transport protocol '" + type + "'");
			RemotingState remotingState = registry.getRemotingState(type);
			assertNull(remotingState);
		}
	}


	@Test
	public void testLoginLogout() {
		LoginCredentials credentials = new LoginCredentials("alice", "password");

		// LOGIN
		gatekeeper.login(credentials);
		User user = userRegistry.getUser(credentials.getLocalUsername());
		assertEquals(new UserUrl("alice", "deus.org"), user.getUserId());
		assertTrue(userRegistry.hasUser(credentials.getLocalUsername()));

		// LOGOUT
		gatekeeper.logout(credentials.getLocalUsername());
		assertFalse(userRegistry.hasUser(credentials.getLocalUsername()));
	}

}
