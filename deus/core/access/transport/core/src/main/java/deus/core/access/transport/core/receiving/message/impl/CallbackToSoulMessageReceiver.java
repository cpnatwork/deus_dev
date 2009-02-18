package deus.core.access.transport.core.receiving.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.DenySubscriptionMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionMessage;
import deus.core.access.transport.core.messages.RequestSubscriptionMessage;
import deus.core.access.transport.core.messages.SubscribeMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.UnsubscribeMessage;
import deus.core.access.transport.core.receiving.message.MessageReceiver;
import deus.core.access.transport.core.receiving.soulcallback.PublisherExportedToPeer;
import deus.core.access.transport.core.receiving.soulcallback.SoulCallbackRegistry;
import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;
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

		PublisherExportedToPeer publisherCommandReceiver = registry.getPublisher();
		SubscriberExportedToPeer subscriberCommandReceiver = registry.getSubscriber();

		// USE CASE: SUBSCRIBE
		if (message instanceof SubscribeMessage) {
			if (message instanceof RequestSubscriptionMessage) {
				UserMetadata senderMetadata = ((RequestSubscriptionMessage) message).getSubscriberMetadata();
				publisherCommandReceiver.addSubscriber(receiverId, senderId, senderMetadata);
			}
			else if (message instanceof GrantSubscriptionMessage)
				subscriberCommandReceiver.acknowledgeSubscription(receiverId, senderId);
			else if (message instanceof DenySubscriptionMessage)
				subscriberCommandReceiver.denySubscription(receiverId, senderId);
			else
				throw new IllegalArgumentException("cannot handle command " + message);
		}
		// USE CASE: UNSUBSCRIBE
		else if (message instanceof UnsubscribeMessage)
			publisherCommandReceiver.deleteSubscriber(receiverId, senderId);
		else
			throw new IllegalArgumentException("cannot handle command " + message);
	}

}
