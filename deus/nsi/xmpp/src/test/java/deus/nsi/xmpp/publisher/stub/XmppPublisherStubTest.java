package deus.nsi.xmpp.publisher.stub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		
		publisherSkeleton.connect();
	}

	@Test
	public void testAddObserver() throws InterruptedException {
		assertEquals(0, publisher.countObservers());
		publisherStub.addObserver(subscriberMetadata);
		// we have to wait for the answer to arrive from the XMPP server
		Thread.sleep(1000);
		assertEquals(1, publisher.countObservers());
	}


	@Test
	public void testDeleteObserver() throws InterruptedException {
		assertEquals(1, publisher.countObservers());
		publisherStub.deleteObserver(subscriberMetadata);
		// we have to wait for the answer to arrive from the XMPP server
		Thread.sleep(1000);
		assertEquals(0, publisher.countObservers());
	}


	@Test
	public void testGetPublisherMetadata() {
		assertTrue(publisherStub.getPublisherMetadata().equals(publisherMetadata));
	}

}
