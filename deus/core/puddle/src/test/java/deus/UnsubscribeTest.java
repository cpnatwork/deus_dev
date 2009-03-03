package deus;

import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/soul.xml" })
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
	
	
	// FIXME: test is not working, since subscriber is not in LoS on publisher side and thus cannot be removed
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
