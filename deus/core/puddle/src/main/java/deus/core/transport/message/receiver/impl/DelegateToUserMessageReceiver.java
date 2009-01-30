package deus.core.transport.message.receiver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.core.transport.id.TransportId;
import deus.core.transport.id.TransportIdUserIdMapper;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.DenySubscriptionMessage;
import deus.core.transport.message.GrantSubscriptionMessage;
import deus.core.transport.message.RequestSubscriptionMessage;
import deus.core.transport.message.SubscribeMessage;
import deus.core.transport.message.UnsubscribeMessage;
import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class DelegateToUserMessageReceiver implements MessageReceiver {

	@Autowired
	private UserRegistry userRegistry;
	
	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;
	
	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(TransportMessage message, String transportProtocolId) {
		TransportIdUserIdMapper mapper = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId).getTransportIdUserIdMapper();

		UserId receiverId = mapper.map(message.getReceiverTid());
		UserId senderId = mapper.map(message.getReceiverTid());
		
		User user = userRegistry.getOrCreateTemporaryUser(receiverId);
		RemoteCalledSubscriber subscriber = user.getSubscriber();
		RemoteCalledPublisher publisher = user.getPublisher();
	
		// USE CASE: SUBSCRIBE
		if(message instanceof SubscribeMessage) {
			if(message instanceof RequestSubscriptionMessage) {
				UserMetadata senderMetadata = ((RequestSubscriptionMessage)message).getSenderMetadata());
				// FIXME: change interface of publisher to take these arguments
				publisher.addObserver(senderId, senderMetadata);
			}
			else if(message instanceof GrantSubscriptionMessage)
				// FIXME: change interface of subscriber to take these arguments
				subscriber.acknowledgeSubscription(senderId);
			else if(message instanceof DenySubscriptionMessage)
				// FIXME: change interface of subscriber to take these arguments
				subscriber.denySubscription(senderId);
			else
				throw new IllegalArgumentException("cannot handle command " + message);
		}
		// USE CASE: UNSUBSCRIBE
		else if(message instanceof UnsubscribeMessage)
			// FIXME: change interface of publisher to take these arguments
			publisher.deleteObserver(senderId);
		else
			throw new IllegalArgumentException("cannot handle command " + message);
	}
	
}
