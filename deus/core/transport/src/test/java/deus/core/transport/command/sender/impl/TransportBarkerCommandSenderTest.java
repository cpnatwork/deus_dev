package deus.core.transport.command.sender.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.transport.command.sender.BarkerCommandSender;
import deus.core.transport.message.DenySubscriptionMessage;
import deus.core.transport.message.GrantSubscriptionMessage;
import deus.core.transport.message.TransportMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/transport/test.xml" })
public class TransportBarkerCommandSenderTest extends AbstractCommandSenderTest {

	@Autowired
	private BarkerCommandSender transportBarkerCommandSender;


	@Test
	public void testDenySubscription() {
		transportBarkerCommandSender.grantSubscription(subscriberId, publisherId);

		TransportMessage expectedMessage = new GrantSubscriptionMessage();
		setTids(expectedMessage, publisherId, subscriberId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);
	}


	@Test
	public void testGrantSubscription() {
		transportBarkerCommandSender.denySubscription(subscriberId, publisherId);

		TransportMessage expectedMessage = new DenySubscriptionMessage();
		setTids(expectedMessage, publisherId, subscriberId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);
	}

}
