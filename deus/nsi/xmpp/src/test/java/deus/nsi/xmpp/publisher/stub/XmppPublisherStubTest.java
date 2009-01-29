package deus.nsi.xmpp.publisher.stub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.soul.publisher.Publisher;
import deus.core.soul.publisher.stub.PublisherStub;
import deus.model.user.UserMetadata;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.publisher.impl.skeleton.XmppPublisherSkeleton;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/nsi/xmpp/xmpp.xml", "/deus/nsi/xmpp/publisher/publisher.xml",
		"/deus/nsi/xmpp/subscriber/subscriber.xml" })
public class XmppPublisherStubTest {

	@Autowired
	private Publisher publisher;

	@Autowired
	private XmppPublisherSkeleton publisherSkeleton;

	@Autowired
	private PublisherStub publisherStub;

	@Autowired
	private UserMetadata publisherMetadata;

	@Autowired
	private UserMetadata subscriberMetadata;

	@Autowired
	@Qualifier("publisher")
	private XmppConversation publisherXmppConversation;

	@Autowired
	@Qualifier("subscriber")
	private XmppConversation subscriberXmppConversation;


	@Before
	public void setUp() {
		publisherXmppConversation.connect();
		publisherXmppConversation.login();
		subscriberXmppConversation.connect();
		subscriberXmppConversation.login();
		
		publisherXmppConversation.clearRoster();
		subscriberXmppConversation.clearRoster();
		publisherSkeleton.connect();
	}


	@After
	public void tearDown() {
		publisherXmppConversation.clearRoster();
		subscriberXmppConversation.clearRoster();
		publisherSkeleton.disconnect();
		
		publisherXmppConversation.end();
		subscriberXmppConversation.end();
	}

	

	@Test
	public void testAddObserver() throws InterruptedException {
		publisherStub.addObserver(subscriberMetadata);
		// we have to wait for the answer to arrive from the XMPP server
		Thread.sleep(1000);
		assertEquals(1, publisher.countObservers());
	}


	@Test
	public void testDeleteObserver() throws InterruptedException {
		publisherStub.addObserver(subscriberMetadata);
		publisherStub.deleteObserver(subscriberMetadata);
		// we have to wait for the answer to arrive from the XMPP server
		Thread.sleep(1000);
		assertEquals(0, publisher.countObservers());
	}


	@Test
	public void testGetPublisherMetadata() {
		assertTrue(publisherStub.getPublisherId().equals(publisherMetadata.getUserId()));
	}

}
