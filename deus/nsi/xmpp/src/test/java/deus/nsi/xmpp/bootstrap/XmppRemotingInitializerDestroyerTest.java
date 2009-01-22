package deus.nsi.xmpp.bootstrap;


import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.User;
import deus.model.user.UserMetadata;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/core.xml", "/deus/model/model.xml",
		"/deus/nsi/xmpp/xmpp.xml" })
public class XmppRemotingInitializerDestroyerTest {


	User user;

	@Resource
	UserMetadata userMetadata;

	@Autowired
	XmppRemotingInitializerDestroyer xmppRemotingInitializerDestroyer;


	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setUserMetadata(userMetadata);
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSetUp() {
		xmppRemotingInitializerDestroyer.setUp(user);
		// TODO: checks
	}


	@Test
	public void testTearDown() {
		// TODO: test
		//xmppRemotingInitializerDestroyer.tearDown(user);
	}

}
