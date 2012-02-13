/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/soul.xml" })
/**
 * The Class SubscribeTest.
 */
public class SubscribeTest extends AbstractUseCaseTest {

//	private User bob;
//
//	private User alice;


	/**
 * Sets the up.
 * 
 * @throws Exception
 *             the exception
 */
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


	/**
	 * Test request subscription.
	 * 
	 * @return the subscription request
	 */
	private SubscriptionRequest testRequestSubscription() {
//		// REQUEST SUBSCRIPTION
//		assertEquals(0, bob.getListOfPublishers().size());
//		assertEquals(0, alice.getListOfSubscribers().size());
//
//		bob.getSubscriber().subscribe(alice.getUserId(), alice.getUserMetadata());
//
//		assertEquals(1, bob.getListOfPublishers().size());
//		assertTrue(bob.getListOfPublishers().containsKey(alice.getUserMetadata()));
//		assertEquals(SubscriberSideSubscriptionState.requested, bob.getListOfPublishers().get(alice.getUserMetadata()));
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
//		SubscriptionRequest request = (SubscriptionRequest) decision;
//		assertEquals(bob.getUserMetadata(), request.getSubscriberMetadata());
//
//		return request;
		return null;
	}



	/**
	 * Test accept request.
	 * 
	 * @param request
	 *            the request
	 */
	private void testAcceptRequest(SubscriptionRequest request) {
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
//		assertEquals(SubscriberSideSubscriptionState.established, bob.getListOfPublishers().get(alice.getUserMetadata()));
//
//		// check for notice in bobs attention list
//		testAttentionList(bob, 1, 0);
//
//
//		AttentionElement ae = bob.getBarker().getUnnoticedAttentionList().get(0);
//		testDateNow(ae.getCreationDate());
//		SubscriptionRequestGrantedNotice notice = (SubscriptionRequestGrantedNotice) ae;
//
//		assertEquals(alice.getUserMetadata(), notice.getPublisherMetadata());
//
//		bob.getBarker().noticeAttentionElement(notice);
//
//
//		testAttentionList(bob, 0, 1);
	}

	// TODO: REENABLE
	/**
	 * Test request subscription accept.
	 */
	@Test
	public void testRequestSubscriptionAccept() {
//		SubscriptionRequest request = testRequestSubscription();
//
//		testAcceptRequest(request);
	}


	// TODO: REENABLE
	/**
	 * Test request subscription deny.
	 */
	@Test
	public void testRequestSubscriptionDeny() {
//		SubscriptionRequest request = testRequestSubscription();
//
//		testDenyRequest(request);
	}


	/**
	 * Test deny request.
	 * 
	 * @param request
	 *            the request
	 */
	private void testDenyRequest(SubscriptionRequest request) {
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
//		SubscriptionRequestDeniedNotice notice = (SubscriptionRequestDeniedNotice) ae;
//
//		assertEquals(alice.getUserMetadata(), notice.getPublisherMetadata());
//
//		bob.getBarker().noticeAttentionElement(notice);
//
//		testAttentionList(bob, 0, 1);
	}


	/**
	 * Tear down.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
//		userRegistry.unregisterUser(alice.getUserId());
//		userRegistry.unregisterUser(bob.getUserId());
	}

}
