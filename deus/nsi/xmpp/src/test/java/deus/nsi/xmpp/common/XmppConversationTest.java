package deus.nsi.xmpp.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.transportid.XmppTransportId;
import deus.nsi.xmpp.util.PacketPrinter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/nsi/xmpp/xmpp_pub-sub.xml" })
public class XmppConversationTest {

	@Autowired
	private PublisherMetadata publisherMetadata;

	@Autowired
	private SubscriberMetadata subscriberMetadata;

	@Autowired
	@Qualifier("publisher")
	private XmppConversation publisherXmppConversation;

	@Autowired
	@Qualifier("subscriber")
	private XmppConversation subscriberXmppConversation;

	private int receivedPacketCount;


	@Before
	public void setUp() throws Exception {
		receivedPacketCount = 0;

		publisherXmppConversation.start();
		subscriberXmppConversation.start();
	}


	@After
	public void tearDown() throws Exception {
		publisherXmppConversation.end();
		subscriberXmppConversation.end();
	}


	@Test
	public void testStartEnd() {
		assertTrue(publisherXmppConversation.isStarted());
		publisherXmppConversation.end();
		assertFalse(publisherXmppConversation.isStarted());
		publisherXmppConversation.start();
		assertTrue(publisherXmppConversation.isStarted());
	}


	@Test
	@Repeat(2)
	public void testRoster() throws XMPPException {
		Roster roster = publisherXmppConversation.getRoster();
		assertEquals(0, roster.getEntries().size());
		roster.createEntry(subscriberMetadata.getUserId().toString(), subscriberMetadata.getFullName(), null);
		assertEquals(1, roster.getEntries().size());
		publisherXmppConversation.clearRoster();
		assertEquals(0, roster.getEntries().size());
	}


	class MyPacketListener implements PacketListener {

		@Override
		public void processPacket(Packet packet) {
			PacketPrinter printer = new PacketPrinter();
			System.out.println(printer.printPacket(packet));

			receivedPacketCount++;
		}

	};


	@Test
	public void testPacketListener() throws InterruptedException {
		PacketListener listener = new MyPacketListener();

		PacketFilter filter = new PacketFilter() {
			@Override
			public boolean accept(Packet arg0) {
				return true;
			}
		};

		publisherXmppConversation.addPacketListener(listener, filter);

		Message message = new Message();
		message.setFrom(subscriberMetadata.getUserId().toString());
		message.setBody("Hello " + publisherMetadata.getFullName() + "!");

		subscriberXmppConversation.sendPacket(message, publisherMetadata.getUserId().getTransportId(
				XmppTransportId.class));
		Thread.sleep(1000);
		assertEquals(1, receivedPacketCount);

		publisherXmppConversation.removePacketListener(listener);

		subscriberXmppConversation.sendPacket(message, publisherMetadata.getUserId().getTransportId(
				XmppTransportId.class));
		// still 1, since we removed the packet listener
		assertEquals(1, receivedPacketCount);
	}
}
