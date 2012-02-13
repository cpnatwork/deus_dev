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

import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/soul.xml" })
/**
 * The Class UnsubscribeTest.
 */
public class UnsubscribeTest extends AbstractUseCaseTest {

//	@Autowired
//	private Gatekeeper gatekeeper;

//	private User bob;
//
//	private User alice;


//	@Before
//	public void setUp() throws Exception {
//		gatekeeper.login(new LoginCredentials("bob", "password"));
//		bob = userRegistry.getUser("bob");
//
//		gatekeeper.login(new LoginCredentials("alice", "password"));
//		alice = userRegistry.getUser("alice");
//	}

	/**
 * Test unsubscribe granted subscription.
 */
@Test
	public void testUnsubscribeGrantedSubscription() {
//		LopEntry lopEntry = new LopEntry();
//		lopEntry.setPublisherMetadata(alice.getUserMetadata());
//		lopEntry.setSubscriptionState(SubscriberSideSubscriptionState.established);
//		bob.getListOfPublishers().put(alice.getUserId(), lopEntry);
//		
//		LosEntry losEntry = new LosEntry();
//		losEntry.setSubscriberMetadata(bob.getUserMetadata());
//		alice.getListOfSubscribers().put(bob.getUserId(), losEntry);
//		
//		testAttentionList(bob, 0, 0);
//		testAttentionList(alice, 0, 0);
//		bob.getSubscriber().unsubscribe(alice.getUserMetadata());
//		
//		testAttentionList(bob, 0, 0);
//		testAttentionList(alice, 1, 0);
//		SubscribedProfileDeletedNotice notice = (SubscribedProfileDeletedNotice)alice.getBarker().getUnnoticedAttentionList().get(0);
//		testDateNow(notice.getCreationDate());
//		assertEquals(bob.getUserMetadata(), notice.getSubscriberMetadata());
//		
//		alice.getBarker().noticeAttentionElement(notice);
//		
//		testAttentionList(alice, 0, 1);
	}
	
	
	// FIXME: test is not working, since informationConsumer is not in LoS on publisher side and thus cannot be removed
	/**
	 * Test unsubscribe requested subscription.
	 */
	@Test
	public void testUnsubscribeRequestedSubscription() {
		/*
		bob.getListOfPublishers().put(alice.getUserMetadata(), SubscriberSideSubscriptionState.requested);
		
		testAttentionList(bob, 0, 0);
		testAttentionList(alice, 0, 0);
		bob.getSubscriber().unsubscribe(alice.getUserMetadata());
		
		testAttentionList(bob, 0, 0);
		testAttentionList(alice, 1, 0);
		SubscriptionCanceledNotice notice = (SubscriptionCanceledNotice)alice.getBarker().getUnnoticedAttentionList().get(0);
		testDateNow(notice.getCreationDate());
		assertEquals(bob.getUserMetadata(), notice.getSubscriberMetadata());
		
		alice.getBarker().noticeAttentionElement(notice);
		
		testAttentionList(alice, 0, 1);*/
	}
	
	
//	@After
//	public void tearDown() throws Exception {
//		gatekeeper.logout("alice");
//		gatekeeper.logout("bob");
//	}
	
}
