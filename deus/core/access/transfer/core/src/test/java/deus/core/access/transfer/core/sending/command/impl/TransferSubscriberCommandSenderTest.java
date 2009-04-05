package deus.core.access.transfer.core.sending.command.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.transfer.core.messages.TransferMessage;
import deus.core.access.transfer.core.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.core.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.model.dossier.proj.party.Gender;
import deus.model.user.UserMetadata;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/access/transport/core/test.xml" })
public class TransferSubscriberCommandSenderTest extends AbstractCommandSenderTest {

	@Autowired
	private SubscriberCommandSender transportSubscriberCommandSender;


	@Test
	public void testSubscribe() {
		UserMetadata subscriberMetadata = new UserMetadata("Bob", Gender.male);

		transportSubscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);

		TransferMessage expectedMessage = new RequestSubscriptionMessage(subscriberMetadata);
		setTids(expectedMessage, subscriberId, publisherId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);

		assertEquals(subscriberMetadata, ((RequestSubscriptionMessage) lastSentTransportMessage)
				.getSubscriberMetadata());
	}


	@Test
	public void testUnsubscribe() {
		transportSubscriberCommandSender.unsubscribe(subscriberId, publisherId);

		TransferMessage expectedMessage = new UnsubscribeMessage();
		setTids(expectedMessage, subscriberId, publisherId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);
	}

}
