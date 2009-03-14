package deus.core.access.transport.core.receiving.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.connection.establishment.invite.ConfirmSubscriptionOfferNoticeMessage;
import deus.core.access.transport.core.messages.connection.establishment.invite.InviteSubscriberMessage;
import deus.core.access.transport.core.messages.connection.establishment.invite.OfferSubscriptionMessage;
import deus.core.access.transport.core.messages.connection.establishment.invite.RepelSubscriptionOfferNoticeMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.RequestSubscriptionMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.SubscribeToPublisherMessage;
import deus.core.access.transport.core.messages.connection.termination.CancelSubscriptionMessage;
import deus.core.access.transport.core.messages.connection.termination.UnsubscribeMessage;
import deus.core.access.transport.core.receiving.message.MessageReceiver;
import deus.core.access.transport.core.receiving.soulcallback.SoulCallbackRegistry;
import deus.core.access.transport.core.receiving.soulcallback.publishing.PublisherExportedToPeer;
import deus.core.access.transport.core.receiving.soulcallback.subscription.SubscriberExportedToPeer;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("messageReceiver")
public class CallbackToSoulMessageReceiver implements MessageReceiver {

	@Autowired
	private SoulCallbackRegistry registry;


	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(TransportMessage message) {
		UserId senderId = message.getSenderId();
		UserId receiverId = message.getReceiverId();

		PublisherExportedToPeer publisher = registry.getPublisher();
		SubscriberExportedToPeer subscriber = registry.getSubscriber();

		// USE CASE: SUBSCRIBE
		if (message instanceof SubscribeToPublisherMessage) {
			// here: role publisher
			if (message instanceof RequestSubscriptionMessage) {
				UserMetadata senderMetadata = ((RequestSubscriptionMessage) message).getSubscriberMetadata();
				// USE CASE: accept subscription
				publisher.addSubscriber(receiverId, senderId, senderMetadata);
			}
			// here: role subscriber
			else if (message instanceof GrantSubscriptionRequestNoticeMessage)
				subscriber.noticeSubscriptionRequestGranted(receiverId, senderId);
			else if (message instanceof DenySubscriptionRequestNoticeMessage)
				subscriber.noticeSubscriptionRequestDenied(receiverId, senderId);
			else
				throw new IllegalArgumentException("cannot handle command " + message);
		}
		// USE CASE: INVITE SUBSCRIBER
		else if(message instanceof InviteSubscriberMessage) {
			// here: role subscriber
			if (message instanceof OfferSubscriptionMessage) {
				UserMetadata senderMetadata = ((OfferSubscriptionMessage) message).getPublisherMetadata();
				// USE CASE: confirm subscription
				subscriber.addPublisher(receiverId, senderId, senderMetadata);
			}
			// here: role publisher
			else if (message instanceof ConfirmSubscriptionOfferNoticeMessage)
				publisher.subscriptionConfirmed(receiverId, senderId);
			else if (message instanceof RepelSubscriptionOfferNoticeMessage)
				publisher.subscriptionAbstained(receiverId, senderId);
			else
				throw new IllegalArgumentException("cannot handle command " + message);
		}
		// USE CASE: UNSUBSCRIBE
		// here: role publisher
		else if (message instanceof UnsubscribeMessage)
			publisher.deleteSubscriber(receiverId, senderId);
		// USE CASE: CANCEL SUBSCRIPTION
		else if (message instanceof CancelSubscriptionMessage)
			// FIXME: impleemnt
			;
		else
			throw new IllegalArgumentException("cannot handle command " + message);
	}

}
