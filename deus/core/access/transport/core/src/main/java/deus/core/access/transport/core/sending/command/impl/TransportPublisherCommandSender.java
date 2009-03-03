package deus.core.access.transport.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.CancelSubscriptionMessage;
import deus.core.access.transport.core.messages.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.OfferSubscriptionMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.UpdateMessage;
import deus.core.access.transport.core.sending.command.PublisherCommandSender;
import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("publisherCommandSender")
public class TransportPublisherCommandSender implements PublisherCommandSender {
	
	@Autowired
	private TransportMessageSenderHelper transportMessageSenderHelper;


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		TransportMessage transportMessage = new UpdateMessage(digitalCard);
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}

	
	@Override
	public void offerSubscription(UserId publisherId, UserId subscriberId, UserMetadata publisherMetadata) {
		TransportMessage transportMessage = new OfferSubscriptionMessage(publisherMetadata);
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}

	@Override
	public void cancelSubscription(UserId publisherId, UserId subscriberId) {
		TransportMessage transportMessage = new CancelSubscriptionMessage();
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}
	
	



	@Override
	public void grantSubscriptionRequest(UserId publisherId, UserId subscriberId) {
		TransportMessage transportMessage = new GrantSubscriptionRequestNoticeMessage();
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}

	
	@Override
	public void denySubscriptionRequest(UserId publisherId, UserId subscriberId) {
		TransportMessage transportMessage = new DenySubscriptionRequestNoticeMessage();
		transportMessageSenderHelper.send(subscriberId, publisherId, transportMessage);
	}



}
