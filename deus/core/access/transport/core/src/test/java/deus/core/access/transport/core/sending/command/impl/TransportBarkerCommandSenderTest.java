package deus.core.access.transport.core.sending.command.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.transport.core.messages.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.sending.command.BarkerCommandSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/access/transport/core/test.xml" })
public class TransportBarkerCommandSenderTest extends AbstractCommandSenderTest {

	@Autowired
	private BarkerCommandSender transportBarkerCommandSender;


	@Test
	public void testDenySubscription() {
		transportBarkerCommandSender.grantSubscriptionRequest(subscriberId, publisherId);

		TransportMessage expectedMessage = new GrantSubscriptionRequestNoticeMessage();
		setTids(expectedMessage, publisherId, subscriberId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);
	}


	@Test
	public void testGrantSubscription() {
		transportBarkerCommandSender.denySubscriptionRequest(subscriberId, publisherId);

		TransportMessage expectedMessage = new DenySubscriptionRequestNoticeMessage();
		setTids(expectedMessage, publisherId, subscriberId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);
	}

}
