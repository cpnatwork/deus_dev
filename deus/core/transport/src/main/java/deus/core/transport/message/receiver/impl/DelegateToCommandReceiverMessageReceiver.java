package deus.core.transport.message.receiver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.commandreceiver.PublisherCommandReceiver;
import deus.core.transport.commandreceiver.SubscriberCommandReceiver;
import deus.core.transport.message.DenySubscriptionMessage;
import deus.core.transport.message.GrantSubscriptionMessage;
import deus.core.transport.message.RequestSubscriptionMessage;
import deus.core.transport.message.SubscribeMessage;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.UnsubscribeMessage;
import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocol.TransportIdUserIdMapper;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class DelegateToCommandReceiverMessageReceiver implements MessageReceiver {

	@Autowired
	private PublisherCommandReceiver publisherCommandReceiver;
	
	@Autowired
	private SubscriberCommandReceiver subscriberCommandReceiver;
	
	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;
	
	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(TransportMessage message, String transportProtocolId) {
		TransportIdUserIdMapper mapper = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId).getTransportIdUserIdMapper();

		UserId receiverId = mapper.map(message.getReceiverTid());
		UserId senderId = mapper.map(message.getSenderTid());
		
		// USE CASE: SUBSCRIBE
		if(message instanceof SubscribeMessage) {
			if(message instanceof RequestSubscriptionMessage) {
				UserMetadata senderMetadata = ((RequestSubscriptionMessage)message).getSubscriberMetadata();
				publisherCommandReceiver.addObserver(receiverId, senderId, senderMetadata);
			}
			else if(message instanceof GrantSubscriptionMessage)
				subscriberCommandReceiver.acknowledgeSubscription(receiverId, senderId);
			else if(message instanceof DenySubscriptionMessage)
				subscriberCommandReceiver.denySubscription(receiverId, senderId);
			else
				throw new IllegalArgumentException("cannot handle command " + message);
		}
		// USE CASE: UNSUBSCRIBE
		else if(message instanceof UnsubscribeMessage)
			// FIXME: change interface of publisher to take these arguments
			publisherCommandReceiver.deleteObserver(receiverId, senderId);
		else
			throw new IllegalArgumentException("cannot handle command " + message);
	}
	
}
