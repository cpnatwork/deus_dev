package deus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deus.model.attention.decision.SubscriberRequest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/soul.xml" })
public class SubscribeTest extends AbstractUseCaseTest {

//	private User bob;
//
//	private User alice;


	@Before
	public void setUp() throws Exception {
//		UserUrl userUrlBob = new UserUrl("bob", "deus.org");
//		userRegistry.registerUser(userUrlBob);
//		bob = userRegistry.getUser(userUrlBob);
//
//		
//		UserUrl userUrlAlice = new UserUrl("alice", "deus.org");
//		userRegistry.registerUser(userUrlAlice);
//		alice = userRegistry.getUser(userUrlAlice);
	}


	private SubscriberRequest testRequestSubscription() {
//		// REQUEST SUBSCRIPTION
//		assertEquals(0, bob.getListOfPublishers().size());
//		assertEquals(0, alice.getListOfSubscribers().size());
//
//		bob.getSubscriber().subscribe(alice.getUserId(), alice.getUserMetadata());
//
//		assertEquals(1, bob.getListOfPublishers().size());
//		assertTrue(bob.getListOfPublishers().containsKey(alice.getUserMetadata()));
//		assertEquals(RequestedSubscriptionState.requested, bob.getListOfPublishers().get(alice.getUserMetadata()));
//		assertEquals(0, alice.getListOfSubscribers().size());
//
//		testAttentionList(alice, 1, 0);
//
//		AttentionElement ae = alice.getBarker().getUnnoticedAttentionList().get(0);
//		testDateNow(ae.getCreationDate());
//
//		BinaryDecisionToMake decision = (BinaryDecisionToMake) ae;
//		assertEquals(DecisionType.subscriberRequest, decision.getType());
//
//		SubscriberRequest request = (SubscriberRequest) decision;
//		assertEquals(bob.getUserMetadata(), request.getSubscriberMetadata());
//
//		return request;
		return null;
	}



	private void testAcceptRequest(SubscriberRequest request) {
//		// ACCEPT REQUEST
//		testAttentionList(bob, 0, 0);
//
//		assertFalse(request.isDecisionMade());
//		request.setDecisionPositive();
//		assertTrue(request.isDecisionMade());
//		alice.getBarker().processDecision(request);
//
//		testAttentionList(alice, 0, 1);
//
//		assertTrue(alice.getListOfSubscribers().containsKey(bob.getUserId()));
//		assertEquals(1, alice.getListOfSubscribers().size());
//
//		assertEquals(1, bob.getListOfPublishers().size());
//		assertTrue(bob.getListOfPublishers().containsKey(alice.getUserMetadata()));
//		assertEquals(RequestedSubscriptionState.granted, bob.getListOfPublishers().get(alice.getUserMetadata()));
//
//		// check for notice in bobs attention list
//		testAttentionList(bob, 1, 0);
//
//
//		AttentionElement ae = bob.getBarker().getUnnoticedAttentionList().get(0);
//		testDateNow(ae.getCreationDate());
//		SubscriptionGrantedNotice notice = (SubscriptionGrantedNotice) ae;
//
//		assertEquals(alice.getUserMetadata(), notice.getPublisherMetadata());
//
//		bob.getBarker().noticeAttentionElement(notice);
//
//
//		testAttentionList(bob, 0, 1);
	}

	// TODO: REENABLE
	@Test
	public void testRequestSubscriptionAccept() {
//		SubscriberRequest request = testRequestSubscription();
//
//		testAcceptRequest(request);
	}


	// TODO: REENABLE
	@Test
	public void testRequestSubscriptionDeny() {
//		SubscriberRequest request = testRequestSubscription();
//
//		testDenyRequest(request);
	}


	private void testDenyRequest(SubscriberRequest request) {
//		// DENY REQUEST
//		assertFalse(request.isDecisionMade());
//		request.setDecisionNegative();
//		assertTrue(request.isDecisionMade());
//		alice.getBarker().processDecision(request);
//
//		testAttentionList(alice, 0, 1);
//
//		// check for notice in bobs attention list
//		testAttentionList(bob, 1, 0);
//
//		assertEquals(0, alice.getListOfSubscribers().size());
//		assertEquals(0, bob.getListOfPublishers().size());
//
//		AttentionElement ae = bob.getBarker().getUnnoticedAttentionList().get(0);
//		assertEquals((new Date()).getTime(), ae.getCreationDate().getTime(), 500);
//		SubscriptionDeniedNotice notice = (SubscriptionDeniedNotice) ae;
//
//		assertEquals(alice.getUserMetadata(), notice.getPublisherMetadata());
//
//		bob.getBarker().noticeAttentionElement(notice);
//
//		testAttentionList(bob, 0, 1);
	}


	@After
	public void tearDown() throws Exception {
//		userRegistry.unregisterUser(alice.getUserId());
//		userRegistry.unregisterUser(bob.getUserId());
	}

}
