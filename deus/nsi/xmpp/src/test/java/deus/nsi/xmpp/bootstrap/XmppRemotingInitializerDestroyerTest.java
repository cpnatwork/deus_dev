package deus.nsi.xmpp.bootstrap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.UserFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/nsi/xmpp/xmpp.xml", "/deus/core/core.xml",
		"/deus/storage/daos.xml", "/deus/nsi/xmpp/subscriber/subscriber.xml", "/deus/nsi/xmpp/publisher/publisher.xml" })
public class XmppRemotingInitializerDestroyerTest {

	@Autowired
	private UserFactory userFactory;


	@Before
	public void setUp() throws Exception {

	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSetUp() {
		// fail("Not yet implemented");
	}


	@Test
	public void testTearDown() {
		// fail("Not yet implemented");
	}

}
