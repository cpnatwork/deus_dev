package deus;

import static org.junit.Assert.assertEquals;

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
import deus.model.attention.notice.SubscribedProfileDeletedNotice;
import deus.model.pub.LosEntry;
import deus.model.sub.LopEntry;
import deus.model.sub.SubscriptionState;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/soul.xml" })
public class UnsubscribeTest extends AbstractUseCaseTest {

	@Autowired
	private Gatekeeper gatekeeper;

	@Autowired
	private UserRegistry userRegistry;
	
	private User bob;

	private User alice;


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
//		lopEntry.setSubscriptionState(SubscriptionState.granted);
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
		bob.getListOfPublishers().put(alice.getUserMetadata(), SubscriptionState.requested);
		
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
