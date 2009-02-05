package deus.core.transport.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.messages.RequestSubscriptionMessage;
import deus.core.transport.messages.TransportMessage;
import deus.core.transport.messages.UnsubscribeMessage;
import deus.core.transport.sending.command.SubscriberCommandSender;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("subscriberCommandSender")
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
