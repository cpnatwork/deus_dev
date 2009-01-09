package deus.nsi.xmpp.publisher.stub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.Roster.SubscriptionMode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.publisher.Publisher;
import deus.core.publisher.PublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.publisher.impl.skeleton.XmppPublisherSkeleton;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/nsi/xmpp/xmpp_pub-sub.xml", "/deus/nsi/xmpp/publisher/publisher.xml",
		"/deus/nsi/xmpp/subscriber/subscriber.xml" })
public class XmppPublisherStubTest {

	@Autowired
	private Publisher<XmppUserId> publisher;

	@Autowired
	private XmppPublisherSkeleton publisherSkeleton;
	
	@Autowired
	@Qualifier("stub")
	private PublisherStub<XmppUserId> publisherStub;

	@Autowired
	private PublisherMetadata<XmppUserId> publisherMetadata;

	@Autowired
	private SubscriberMetadata<XmppUserId> subscriberMetadata;

	@Before
	public void setUp() {
		
	}

	@Test
	public void testAddObserver() {
		assertEquals(0, publisher.countObservers());
		publisherSkeleton.connect();
		publisherStub.addObserver(subscriberMetadata);
		assertEquals(1, publisher.countObservers());
		System.out.println("test");
	}


	@Test
	public void testDeleteObserver() {
		// publisherStub.deleteObserver(subscriberMetadata);
	}


	@Test
	public void testGetPublisherMetadata() {
		assertTrue(publisherStub.getPublisherMetadata().equals(publisherMetadata));
	}

}
