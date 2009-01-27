package deus;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.User;
import deus.core.UserFactory;
import deus.core.UserRegistry;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.soul.LoginCredentials;
import deus.core.publisher.stub.local.LocalPublisherStub;
import deus.model.attention.AttentionElement;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.DecisionType;
import deus.model.attention.decision.SubscriberRequest;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserUrl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/deus/context.xml", "/deus/model/attention/attentionList.xml", "/deus/storage/daos.xml",
		"/deus/core/core.xml", "/deus/core/core-test.xml" })
public class RequestSubscriptionLocalTransportTest {

	@Resource(name = "gatekeeper")
	private Gatekeeper gatekeeper;
	
	@Autowired
	private UserFactory userFactory;


	private User user;
	
	private User publisherUser;

	private LoginCredentials credentials;

	
	@Before
	public void setUp() throws Exception {
		publisherUser = userFactory.createUser(new UserUrl("alice", "deus.org"));
		credentials = new LoginCredentials();
		user = gatekeeper.login(credentials);

	}


	@Test
	public void testRequestSubscription() {
		
		// REQUEST SUBSCRIPTION
		assertEquals(0, user.getListOfPublishers().size());
		user.getSubscriber().subscribe(publisherUser.getUserId());
		assertEquals(0, user.getListOfPublishers().size());
		
		assertEquals(0, publisherUser.getListOfSubscribers().size());
		assertEquals(1, publisherUser.getBarker().getUnnoticedAttentionList());
		assertEquals(0, publisherUser.getBarker().getNoticedAttentionList());
		
		AttentionElement ae = publisherUser.getBarker().getUnnoticedAttentionList().get(0);
		// TODO: add check for date
		System.out.println("creating date: " + ae.getCreationDate());
		BinaryDecisionToMake decision = (BinaryDecisionToMake)ae;
		assertEquals(DecisionType.subscriberRequest, decision.getType());
		
		SubscriberRequest request = (SubscriberRequest)decision;
		assertEquals(user.getUserMetadata(), request.getSubscriberMetadata());
		
		// ACCEPT REQUEST
		assertFalse(request.isDecisionMade());
		request.setDecisionPositive();
		assertTrue(request.isDecisionMade());
		publisherUser.getBarker().processDecision(request);
		
		assertEquals(0, publisherUser.getBarker().getUnnoticedAttentionList());
		assertEquals(1, publisherUser.getBarker().getNoticedAttentionList());
		
		assertTrue(publisherUser.getListOfSubscribers().contains(user.getUserMetadata()));
		assertEquals(1, publisherUser.getListOfSubscribers().size());
		
		assertTrue(user.getListOfPublishers().contains(user.getUserMetadata()));
		assertEquals(1, user.getListOfPublishers().size());		
		
		gatekeeper.logout(user);
	}


	@After
	public void tearDown() throws Exception {
		publisherUser = null;
		gatekeeper.logout(user);

	}

}
