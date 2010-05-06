package deus.core.access.transfer.core.sending.command.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

@Named("subscriberCommandSender")
public class TransferSubscriberCommandSender implements SubscriberCommandSender {

	@Inject
	private TransferMessageSenderHelper transferMessageSenderHelper;

	
	@Override
	public void subscribe(SubscriberId subscriberId, PublisherId publisherId, UserMetadata subscriberMetadata) {
		TransferMessage transferMessage = new RequestSubscriptionMessage(subscriberMetadata);
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}


	@Override
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId) {
		TransferMessage transferMessage = new UnsubscribeMessage();
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}

	

	@Override
	public void confirmSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId) {
		TransferMessage transferMessage = new ConfirmSubscriptionOfferNoticeMessage();
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}
	
	
	@Override
	public void repelSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId) {
		TransferMessage transferMessage = new RepelSubscriptionOfferNoticeMessage();
		transferMessageSenderHelper.send(publisherId.getUserId(), subscriberId.getUserId(), transferMessage);
	}
	
}
