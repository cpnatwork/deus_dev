package deus.core.transport.sending.command.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.transport.messages.RequestSubscriptionMessage;
import deus.core.transport.messages.TransportMessage;
import deus.core.transport.messages.UnsubscribeMessage;
import deus.core.transport.sending.command.SubscriberCommandSender;
import deus.model.user.UserMetadata;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/transport/test.xml" })
public class TransportSubscriberCommandSenderTest extends AbstractCommandSenderTest {

	@Autowired
	private SubscriberCommandSender transportSubscriberCommandSender;


	@Test
	public void testSubscribe() {
		UserMetadata subscriberMetadata = new UserMetadata(subscriberId, "Bob");

		transportSubscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);

		TransportMessage expectedMessage = new RequestSubscriptionMessage(subscriberMetadata);
		setTids(expectedMessage, subscriberId, publisherId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);

		assertEquals(subscriberMetadata, ((RequestSubscriptionMessage) lastSentTransportMessage)
				.getSubscriberMetadata());
	}


	@Test
	public void testUnsubscribe() {
		transportSubscriberCommandSender.unsubscribe(subscriberId, publisherId);

		TransportMessage expectedMessage = new UnsubscribeMessage();
		setTids(expectedMessage, subscriberId, publisherId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);
	}

}
