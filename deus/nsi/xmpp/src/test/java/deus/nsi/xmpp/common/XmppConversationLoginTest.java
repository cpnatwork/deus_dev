package deus.nsi.xmpp.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jivesoftware.smack.packet.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.model.sub.PublisherMetadata;
import deus.model.user.id.transportid.XmppTransportId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/nsi/xmpp/xmpp.xml",
		"/deus/nsi/xmpp/subscriber/subscriber.xml", "/deus/nsi/xmpp/publisher/publisher.xml" })
public class XmppConversationLoginTest {

	@Autowired
	private PublisherMetadata publisherMetadata;

	@Autowired
	@Qualifier("publisher")
	private XmppConversation pubConv;


	@Before
	public void setUp() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
		pubConv.end();
	}


	@Test
	public void testConnectLogin() {
		assertFalse(pubConv.isConnected());
		assertFalse(pubConv.isLoggedIn());
		pubConv.connect();
		assertTrue(pubConv.isConnected());
		assertFalse(pubConv.isLoggedIn());
		pubConv.login();
		assertTrue(pubConv.isConnected());
		assertTrue(pubConv.isLoggedIn());
		pubConv.end();
		assertFalse(pubConv.isConnected());
		assertFalse(pubConv.isLoggedIn());
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testLogin() {
		pubConv.login(); // login without connect before should fail
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testGetRoster1() {
		pubConv.getRoster();
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testGetRoster2() {
		pubConv.connect();
		pubConv.getRoster();
	}


	@Test
	public void testGetRoster3() {
		pubConv.connect();
		pubConv.login();
		pubConv.getRoster();
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testClearRoster1() {
		pubConv.clearRoster();
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testClearRoster2() {
		pubConv.connect();
		pubConv.clearRoster();
	}


	@Test
	public void testClearRoster3() {
		pubConv.connect();
		pubConv.login();
		pubConv.clearRoster();
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testSendPacket1() {
		Message message = new Message();
		message.setFrom(publisherMetadata.getUserId().toString());
		message.setBody("Hello " + publisherMetadata.getFullName() + "!");

		pubConv.sendPacket(message, publisherMetadata.getUserId().getTransportId(XmppTransportId.class));
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testSendPacket2() {
		pubConv.connect();
		Message message = new Message();
		message.setFrom(publisherMetadata.getUserId().toString());
		message.setBody("Hello " + publisherMetadata.getFullName() + "!");

		pubConv.sendPacket(message, publisherMetadata.getUserId().getTransportId(XmppTransportId.class));
	}


	@Test
	public void testSendPacket3() {
		pubConv.connect();
		pubConv.login();
		Message message = new Message();
		message.setFrom(publisherMetadata.getUserId().toString());
		message.setBody("Hello " + publisherMetadata.getFullName() + "!");

		pubConv.sendPacket(message, publisherMetadata.getUserId().getTransportId(XmppTransportId.class));
	}


	@Test
	@ExpectedException(IllegalStateException.class)
	public void testAddPacketListener1() {
		pubConv.addPacketListener(null, null);
	}

	
	@Test
	@ExpectedException(IllegalArgumentException.class)	// catch IllegalArgumentException here (packetListener we added is null)
	public void testAddPacketListener2() {
		pubConv.connect();
		pubConv.addPacketListener(null, null);
	}


	@Test
	@ExpectedException(IllegalArgumentException.class)	// catch IllegalArgumentException here (packetListener we added is null)
	public void testAddPacketListener3() {
		pubConv.connect();
		pubConv.login();
		pubConv.addPacketListener(null, null);
	}

}
