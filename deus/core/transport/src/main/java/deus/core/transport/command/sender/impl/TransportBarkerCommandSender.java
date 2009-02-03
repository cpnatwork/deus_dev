package deus.core.transport.command.sender.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.command.sender.BarkerCommandSender;
import deus.core.transport.message.DenySubscriptionMessage;
import deus.core.transport.message.GrantSubscriptionMessage;
import deus.core.transport.message.TransportMessage;
import deus.model.user.id.UserId;

@Component
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
