package deus.core.access.transfer.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.messages.publication.connection.establish.invite.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.core.messages.publication.connection.establish.invite.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.core.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.core.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
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
