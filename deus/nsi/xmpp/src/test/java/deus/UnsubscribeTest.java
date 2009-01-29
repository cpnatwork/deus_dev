package deus;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.soul.User;
import deus.core.soul.gatekeeper.Gatekeeper;
import deus.core.soul.gatekeeper.soul.LoginCredentials;
import deus.model.attention.notice.SubscriptionCanceledNotice;
import deus.model.sub.SubscriptionState;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/core.xml",
//		"/deus/nsi/xmpp/xmpp.xml" })
public class UnsubscribeTest extends AbstractUseCaseTest {
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


	@Test
	public void testUnsubscribeGrantedSubscription() {
		bob.getListOfPublishers().put(alice.getUserMetadata(), SubscriptionState.granted);
		alice.getListOfSubscribers().add(bob.getUserMetadata());

		testAttentionList(bob, 0, 0);
		testAttentionList(alice, 0, 0);
		bob.getSubscriber().unsubscribe(alice.getUserMetadata());

		testAttentionList(bob, 0, 0);
		testAttentionList(alice, 1, 0);
		SubscriptionCanceledNotice notice = (SubscriptionCanceledNotice) alice.getBarker().getUnnoticedAttentionList()
				.get(0);
		testDateNow(notice.getCreationDate());
		assertEquals(bob.getUserMetadata(), notice.getSubscriberMetadata());

		alice.getBarker().noticeAttentionElement(notice);

		testAttentionList(alice, 0, 1);
	}


	// FIXME: test is not working, since subscriber is not in LoS on publisher side and thus cannot be removed
	@Test
	public void testUnsubscribeRequestedSubscription() {
		
		bob.getListOfPublishers().put(alice.getUserMetadata(), SubscriptionState.requested);
		
		testAttentionList(bob, 0, 0); testAttentionList(alice, 0, 0);
		bob.getSubscriber().unsubscribe(alice.getUserMetadata());
		
		testAttentionList(bob, 0, 0); testAttentionList(alice, 1, 0); SubscriptionCanceledNotice notice =
		(SubscriptionCanceledNotice)alice.getBarker().getUnnoticedAttentionList().get(0);
		testDateNow(notice.getCreationDate()); assertEquals(bob.getUserMetadata(), notice.getSubscriberMetadata());
		
		alice.getBarker().noticeAttentionElement(notice);
		
		testAttentionList(alice, 0, 1);
		 
	}


	@After
	public void tearDown() throws Exception {
		gatekeeper.logout(alice);
		gatekeeper.logout(bob);
	}
*/

}
