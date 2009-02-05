package deus.core.access.transport.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.DenySubscriptionMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.sending.command.BarkerCommandSender;
import deus.model.user.id.UserId;

@Component("barkerCommandSender")
public class TransportBarkerCommandSender implements BarkerCommandSender {

	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;

	@Override
	public void denySubscription(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new DenySubscriptionMessage();
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}


	@Override
	public void grantSubscription(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new GrantSubscriptionMessage();
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}

}
