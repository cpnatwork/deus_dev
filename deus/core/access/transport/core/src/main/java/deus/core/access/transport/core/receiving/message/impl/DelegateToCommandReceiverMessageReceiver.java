package deus.core.access.transport.core.receiving.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.DenySubscriptionMessage;
import deus.core.access.transport.core.messages.GrantSubscriptionMessage;
import deus.core.access.transport.core.messages.RequestSubscriptionMessage;
import deus.core.access.transport.core.messages.SubscribeMessage;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.UnsubscribeMessage;
import deus.core.access.transport.core.receiving.command.CommandReceiverRegistry;
import deus.core.access.transport.core.receiving.command.PublisherCommandReceiver;
import deus.core.access.transport.core.receiving.command.SubscriberCommandReceiver;
import deus.core.access.transport.core.receiving.message.MessageReceiver;
import deus.core.access.transport.core.soul.mapper.TransportIdMapper;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("messageReceiver")
public class DelegateToCommandReceiverMessageReceiver implements MessageReceiver {

	@Autowired
	private CommandReceiverRegistry registry;

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;


	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(String transportProtocolId, TransportMessage message) {
		TransportIdMapper transportIdMapper = transportProtocolRegistry.getRegisteredTransportProtocol(
				transportProtocolId).getTransportIdMapper();

		UserId receiverId = transportIdMapper.resolveLocal(message.getReceiverTid());
		UserId senderId = message.getSenderId();

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
			publisherCommandReceiver.deleteObserver(receiverId, senderId);
		else
			throw new IllegalArgumentException("cannot handle command " + message);
	}

}
