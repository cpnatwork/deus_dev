package deus.core.transport.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.messages.DenySubscriptionMessage;
import deus.core.transport.messages.GrantSubscriptionMessage;
import deus.core.transport.messages.TransportMessage;
import deus.core.transport.sending.command.BarkerCommandSender;
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
