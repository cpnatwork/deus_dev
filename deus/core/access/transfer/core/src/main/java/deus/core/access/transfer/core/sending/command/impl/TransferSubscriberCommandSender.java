package deus.core.access.transfer.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

@Component("subscriberCommandSender")
public class TransferSubscriberCommandSender implements SubscriberCommandSender {

	@Autowired
	private TransferMessageSenderHelper transferMessageSenderHelper;

	
	@Override
	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata subscriberMetadata) {
		TransferMessage transferMessage = new RequestSubscriptionMessage(subscriberMetadata);
		transferMessageSenderHelper.send(publisherId, subscriberId, transferMessage);
	}


	@Override
	public void unsubscribe(UserId subscriberId, UserId publisherId) {
		TransferMessage transferMessage = new UnsubscribeMessage();
		transferMessageSenderHelper.send(publisherId, subscriberId, transferMessage);
	}

	

	@Override
	public void confirmSubscriptionOffer(UserId subscriberId, UserId publisherId) {
		TransferMessage transferMessage = new ConfirmSubscriptionOfferNoticeMessage();
		transferMessageSenderHelper.send(publisherId, subscriberId, transferMessage);
	}
	
	
	@Override
	public void repelSubscriptionOffer(UserId subscriberId, UserId publisherId) {
		TransferMessage transferMessage = new RepelSubscriptionOfferNoticeMessage();
		transferMessageSenderHelper.send(publisherId, subscriberId, transferMessage);
	}
	
}
