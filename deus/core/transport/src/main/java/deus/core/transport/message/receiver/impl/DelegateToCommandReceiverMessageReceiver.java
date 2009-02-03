package deus.core.transport.message.receiver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.transport.command.receiver.PublisherCommandReceiver;
import deus.core.transport.command.receiver.SubscriberCommandReceiver;
import deus.core.transport.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.transport.message.DenySubscriptionMessage;
import deus.core.transport.message.GrantSubscriptionMessage;
import deus.core.transport.message.RequestSubscriptionMessage;
import deus.core.transport.message.SubscribeMessage;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.UnsubscribeMessage;
import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocol.TransportIdUserIdMapper;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Configurable
public class DelegateToCommandReceiverMessageReceiver implements MessageReceiver {

	@Autowired
	private PublisherCommandReceiver publisherCommandReceiver;

	@Autowired
	private SubscriberCommandReceiver subscriberCommandReceiver;

	@Autowired
	private TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;
	
	private final String transportProtocolId;
	private final TransportIdUserIdMapper mapper;


	public DelegateToCommandReceiverMessageReceiver(String transportProtocolId, TransportIdUserIdMapper mapper) {
		this.transportProtocolId = transportProtocolId;
		this.mapper = mapper;
	}


	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(TransportMessage message) {
		UserId receiverId = mapper.map(message.getReceiverTid());
		UserId senderId = transportProtocolDiscoveryStrategy.resolveUserId(transportProtocolId, message.getSenderTid());

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
