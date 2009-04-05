package deus.core.access.transfer.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.invite.OfferSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.CancelSubscriptionMessage;
import deus.core.access.transfer.core.messages.publication.UpdateMessage;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("publisherCommandSender")
// FIXME: Rename to transfer
public class TransferPublisherCommandSender implements PublisherCommandSender {
	
	@Autowired
	private TransferMessageSenderHelper transferMessageSenderHelper;


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		TransferMessage transferMessage = new UpdateMessage(digitalCard);
		transferMessageSenderHelper.send(subscriberId, publisherId, transferMessage);
	}

	
	@Override
	public void offerSubscription(UserId publisherId, UserId subscriberId, UserMetadata publisherMetadata) {
		TransferMessage transferMessage = new OfferSubscriptionMessage(publisherMetadata);
		transferMessageSenderHelper.send(subscriberId, publisherId, transferMessage);
	}

	@Override
	public void cancelSubscription(UserId publisherId, UserId subscriberId) {
		TransferMessage transferMessage = new CancelSubscriptionMessage();
		transferMessageSenderHelper.send(subscriberId, publisherId, transferMessage);
	}
	
	



	@Override
	public void grantSubscriptionRequest(UserId publisherId, UserId subscriberId) {
		TransferMessage transferMessage = new GrantSubscriptionRequestNoticeMessage();
		transferMessageSenderHelper.send(subscriberId, publisherId, transferMessage);
	}

	
	@Override
	public void denySubscriptionRequest(UserId publisherId, UserId subscriberId) {
		TransferMessage transferMessage = new DenySubscriptionRequestNoticeMessage();
		transferMessageSenderHelper.send(subscriberId, publisherId, transferMessage);
	}



}
