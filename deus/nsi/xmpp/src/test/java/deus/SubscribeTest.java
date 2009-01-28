package deus;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/core.xml",
//		"/deus/nsi/xmpp/xmpp.xml" })
public class SubscribeTest extends AbstractUseCaseTest {
/*
	@Resource(name = "gatekeeper")
	private Gatekeeper gatekeeper;

	private User bob;

	private User alice;


	@Before
	public void setUp() throws Exception {
		bob = gatekeeper.login(new LoginCredentials("bob", "password"));

		alice = gatekeeper.login(new LoginCredentials("alice", "password"));
	}


	private SubscriberRequest testRequestSubscription() throws InterruptedException {
		// REQUEST SUBSCRIPTION
		assertEquals(0, bob.getListOfPublishers().size());
		assertEquals(0, alice.getListOfSubscribers().size());

		bob.getSubscriber().subscribe(alice.getUserMetadata());

		assertEquals(1, bob.getListOfPublishers().size());
		assertTrue(bob.getListOfPublishers().containsKey(alice.getUserMetadata()));
		assertEquals(SubscriptionState.requested, bob.getListOfPublishers().get(alice.getUserMetadata()));
		assertEquals(0, alice.getListOfSubscribers().size());

		
		
		Thread.sleep(1000);
		
		
		
		testAttentionList(alice, 1, 0);

		AttentionElement ae = alice.getBarker().getUnnoticedAttentionList().get(0);
		testDateNow(ae.getCreationDate());

		BinaryDecisionToMake decision = (BinaryDecisionToMake) ae;
		assertEquals(DecisionType.subscriberRequest, decision.getType());

		SubscriberRequest request = (SubscriberRequest) decision;
		assertEquals(bob.getUserMetadata(), request.getSubscriberMetadata());

		return request;
	}


	private void testAcceptRequest(SubscriberRequest request) throws InterruptedException {
		// ACCEPT REQUEST
		testAttentionList(bob, 0, 0);

		assertFalse(request.isDecisionMade());
		request.setDecisionPositive();
		assertTrue(request.isDecisionMade());
		alice.getBarker().processDecision(request);
		
		testAttentionList(alice, 0, 1);

		assertTrue(alice.getListOfSubscribers().contains(bob.getUserMetadata()));
		assertEquals(1, alice.getListOfSubscribers().size());

		
		
		Thread.sleep(1000);

		
		
		assertEquals(1, bob.getListOfPublishers().size());
		assertTrue(bob.getListOfPublishers().containsKey(alice.getUserMetadata()));
		assertEquals(SubscriptionState.granted, bob.getListOfPublishers().get(alice.getUserMetadata()));

		// check for notice in bobs attention list
		testAttentionList(bob, 1, 0);


		AttentionElement ae = bob.getBarker().getUnnoticedAttentionList().get(0);
		testDateNow(ae.getCreationDate());
		SubscriptionGrantedNotice notice = (SubscriptionGrantedNotice) ae;

		assertEquals(alice.getUserMetadata(), notice.getPublisherMetadata());

		bob.getBarker().noticeAttentionElement(notice);


		testAttentionList(bob, 0, 1);
	}


	@Test
	public void testRequestSubscriptionAccept() throws InterruptedException {
		SubscriberRequest request = testRequestSubscription();

		testAcceptRequest(request);
	}


	@Test
	public void testRequestSubscriptionDeny() throws InterruptedException {
		SubscriberRequest request = testRequestSubscription();

		testDenyRequest(request);
	}


	private void testDenyRequest(SubscriberRequest request) {
		// DENY REQUEST
		assertFalse(request.isDecisionMade());
		request.setDecisionNegative();
		assertTrue(request.isDecisionMade());
		alice.getBarker().processDecision(request);

		testAttentionList(alice, 0, 1);

		// check for notice in bobs attention list
		testAttentionList(bob, 1, 0);

		assertEquals(0, alice.getListOfSubscribers().size());
		assertEquals(0, bob.getListOfPublishers().size());

		AttentionElement ae = bob.getBarker().getUnnoticedAttentionList().get(0);
		assertEquals((new Date()).getTime(), ae.getCreationDate().getTime(), 500);
		SubscriptionDeniedNotice notice = (SubscriptionDeniedNotice) ae;

		assertEquals(alice.getUserMetadata(), notice.getPublisherMetadata());

		bob.getBarker().noticeAttentionElement(notice);

		testAttentionList(bob, 0, 1);
	}


	@After
	public void tearDown() throws Exception {
		gatekeeper.logout(alice);
		gatekeeper.logout(bob);
	}
*/
}
