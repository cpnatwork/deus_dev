package deus.core.access.transport.core.sending.command.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.transport.core.messages.DenySubscriptionMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.sending.command.BarkerCommandSender;

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
