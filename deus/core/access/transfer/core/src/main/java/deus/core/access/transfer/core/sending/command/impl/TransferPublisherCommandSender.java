package deus.core.access.transfer.core.sending.command.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.publication.UpdateMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.OfferSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.CancelSubscriptionMessage;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

@Named("publisherCommandSender")
public class TransferPublisherCommandSender implements PublisherCommandSender {
	
	@Inject
	private TransferMessageSenderHelper transferMessageSenderHelper;


	@Override
	public void update(PublisherId publisherId, SubscriberId subscriberId, DigitalCard digitalCard) {
		TransferMessage transferMessage = new UpdateMessage(digitalCard);
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}

	
	@Override
	public void offerSubscription(PublisherId publisherId, SubscriberId subscriberId, UserMetadata publisherMetadata) {
		TransferMessage transferMessage = new OfferSubscriptionMessage(publisherMetadata);
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}

	@Override
	public void cancelSubscription(PublisherId publisherId, SubscriberId subscriberId) {
		TransferMessage transferMessage = new CancelSubscriptionMessage();
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}
	
	



	@Override
	public void grantSubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId) {
		TransferMessage transferMessage = new GrantSubscriptionRequestNoticeMessage();
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}

	
	@Override
	public void denySubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId) {
		TransferMessage transferMessage = new DenySubscriptionRequestNoticeMessage();
		transferMessageSenderHelper.send(subscriberId.getUserId(), publisherId.getUserId(), transferMessage);
	}



}
