package deus.core.access.transport.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transport.core.messages.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transport.core.messages.RequestSubscriptionMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.UnsubscribeMessage;
import deus.core.access.transport.core.sending.command.SubscriberCommandSender;
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

	

	@Override
	public void confirmSubscriptionOffer(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new ConfirmSubscriptionOfferNoticeMessage();
		transportMessageSenderHelper.send(publisherId, subscriberId, transportMessage);
	}
	
	
	@Override
	public void repelSubscriptionOffer(UserId subscriberId, UserId publisherId) {
		TransportMessage transportMessage = new RepelSubscriptionOfferNoticeMessage();
		transportMessageSenderHelper.send(publisherId, subscriberId, transportMessage);
	}
	
}
