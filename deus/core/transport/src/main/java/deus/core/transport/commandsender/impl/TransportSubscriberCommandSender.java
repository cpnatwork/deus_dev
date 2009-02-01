package deus.core.transport.commandsender.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.commandsender.SubscriberCommandSender;
import deus.core.transport.message.RequestSubscriptionMessage;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.UnsubscribeMessage;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class TransportSubscriberCommandSender implements SubscriberCommandSender {

	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;

	
	@Override
	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata subscriberMetadata) {
		TransportMessage transportMessage = new RequestSubscriptionMessage(subscriberMetadata);
		transportMessageSenderHelper.send(publisherId, subscriberId, transportMessage);
	}


	@Override
	public void unsubscribe(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new UnsubscribeMessage();
		transportMessageSenderHelper.send(publisherId, subscriberId, transportMessage);
	}

}
