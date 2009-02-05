package deus.core.transport.receiving.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.core.mapper.TransportIdMapper;
import deus.core.transport.messages.DenySubscriptionMessage;
import deus.core.transport.messages.GrantSubscriptionMessage;
import deus.core.transport.messages.RequestSubscriptionMessage;
import deus.core.transport.messages.SubscribeMessage;
import deus.core.transport.messages.TransportMessage;
import deus.core.transport.messages.UnsubscribeMessage;
import deus.core.transport.receiving.command.CommandReceiverRegistry;
import deus.core.transport.receiving.command.PublisherCommandReceiver;
import deus.core.transport.receiving.command.SubscriberCommandReceiver;
import deus.core.transport.receiving.message.MessageReceiver;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("messageReceiver")
public class DelegateToCommandReceiverMessageReceiver implements MessageReceiver {

	@Autowired
	private CommandReceiverRegistry registry;

	@Autowired
	private TransportIdMapper transportIdMapper;


	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(String transportProtocolId, TransportMessage message) {
		UserId receiverId = transportIdMapper.resolveLocal(message.getReceiverTid());
		UserId senderId = transportIdMapper.resolveRemote(message.getSenderTid());

		PublisherCommandReceiver publisherCommandReceiver = registry.getPublisherCommandReceiver();
		SubscriberCommandReceiver subscriberCommandReceiver = registry.getSubscriberCommandReceiver();
		
		// USE CASE: SUBSCRIBE
		if (message instanceof SubscribeMessage) {
			if (message instanceof RequestSubscriptionMessage) {
				UserMetadata senderMetadata = ((RequestSubscriptionMessage) message).getSubscriberMetadata();
				publisherCommandReceiver.addObserver(receiverId, senderId, senderMetadata);
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
			// FIXME: change interface of publisher to take these arguments
			publisherCommandReceiver.deleteObserver(receiverId, senderId);
		else
			throw new IllegalArgumentException("cannot handle command " + message);
	}

}
