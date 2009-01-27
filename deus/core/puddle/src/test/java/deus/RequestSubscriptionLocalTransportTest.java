package deus;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.User;
import deus.core.UserFactory;
import deus.core.UserRegistry;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserUrl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/model/attention/attentionList.xml", "/deus/storage/daos.xml",
		"/deus/core/core.xml", "/deus/core/core-test.xml", "/deus/context.xml" })
public class RequestSubscriptionLocalTransportTest {

	@Resource(name = "gatekeeper")
	private Gatekeeper gatekeeper;
	
	@Autowired
	private UserFactory userFactory;

	@Autowired
	private UserRegistry userRegistry;

	private User user;
	
	private User publisherUser;

	private LoginCredentials credentials;

	
	@Before
	public void setUp() throws Exception {
		publisherUser = userFactory.createUser(new UserUrl("alice", "deus.org"));
		credentials = new LoginCredentials();
	}

	@Test
	public void testLogin() {
		user = gatekeeper.login(credentials);
		assertEquals(new UserUrl("username", "deus.org"), user.getUserId());
		assertTrue(userRegistry.hasUser(user.getUserId()));
		gatekeeper.logout(user);
	}

	@Test
	public void testRequestSubscription() {
		user = gatekeeper.login(credentials);
		user.getSubscriber().subscribe(publisherUser.getUserId());
		gatekeeper.logout(user);
	}

	@Test
	public void testLogout() {
		user = gatekeeper.login(credentials);
		gatekeeper.logout(user);
		assertFalse(userRegistry.hasUser(user.getUserId()));
	}


	@After
	public void tearDown() throws Exception {
		publisherUser = null;
	}

}
