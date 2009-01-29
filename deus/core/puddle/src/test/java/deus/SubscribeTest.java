package deus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.gatekeeper.Gatekeeper;
import deus.core.soul.gatekeeper.soul.LoginCredentials;
import deus.model.attention.AttentionElement;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.DecisionType;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.attention.notice.SubscriptionDeniedNotice;
import deus.model.attention.notice.SubscriptionGrantedNotice;
import deus.model.sub.SubscriptionState;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/core.xml" })
public class SubscribeTest extends AbstractUseCaseTest {

	@Resource(name = "gatekeeper")
	private Gatekeeper gatekeeper;

	@Autowired
	private UserRegistry userRegistry;
	
	private User bob;

	private User alice;


	@Before
	public void setUp() throws Exception {
		gatekeeper.login(new LoginCredentials("bob", "password"));
		bob = userRegistry.getUser("bob");

		gatekeeper.login(new LoginCredentials("alice", "password"));
		alice = userRegistry.getUser("alice");
	}


	private SubscriberRequest testRequestSubscription() {
		// REQUEST SUBSCRIPTION
		assertEquals(0, bob.getListOfPublishers().size());
		assertEquals(0, alice.getListOfSubscribers().size());

		bob.getSubscriber().subscribe(alice.getUserMetadata());

		assertEquals(1, bob.getListOfPublishers().size());
		assertTrue(bob.getListOfPublishers().containsKey(alice.getUserMetadata()));
		assertEquals(SubscriptionState.requested, bob.getListOfPublishers().get(alice.getUserMetadata()));
		assertEquals(0, alice.getListOfSubscribers().size());

		testAttentionList(alice, 1, 0);

		AttentionElement ae = alice.getBarker().getUnnoticedAttentionList().get(0);
		testDateNow(ae.getCreationDate());

		BinaryDecisionToMake decision = (BinaryDecisionToMake) ae;
		assertEquals(DecisionType.subscriberRequest, decision.getType());

		SubscriberRequest request = (SubscriberRequest) decision;
		assertEquals(bob.getUserMetadata(), request.getSubscriberMetadata());

		return request;
	}



	private void testAcceptRequest(SubscriberRequest request) {
		// ACCEPT REQUEST
		testAttentionList(bob, 0, 0);

		assertFalse(request.isDecisionMade());
		request.setDecisionPositive();
		assertTrue(request.isDecisionMade());
		alice.getBarker().processDecision(request);

		testAttentionList(alice, 0, 1);

		assertTrue(alice.getListOfSubscribers().contains(bob.getUserMetadata()));
		assertEquals(1, alice.getListOfSubscribers().size());

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
	public void testRequestSubscriptionAccept() {
		SubscriberRequest request = testRequestSubscription();

		testAcceptRequest(request);
	}


	@Test
	public void testRequestSubscriptionDeny() {
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
		gatekeeper.logout("alice");
		gatekeeper.logout("bob");
	}

}
