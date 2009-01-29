package deus.core.transport.receiver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.core.transport.command.Command;
import deus.core.transport.command.DenySubscriptionCommand;
import deus.core.transport.command.GrantSubscriptionCommand;
import deus.core.transport.command.RequestSubscriptionCommand;
import deus.core.transport.command.SubscribeCommand;
import deus.core.transport.command.UnsubscribeCommand;
import deus.core.transport.id.TransportId;
import deus.core.transport.receiver.RemoteCommandReceiver;
import deus.model.user.UserMetadata;

@Component
public class DelegateToUserRemoteCommandReceiver implements RemoteCommandReceiver {

	@Autowired
	private UserRegistry userRegistry;

	
	// TODO: refactor (introduce more receive methods and dispatch in this one)
	@Override
	public void receive(Command command, TransportId senderTid, TransportId receiverTid) {
		User user = userRegistry.getOrCreateTemporaryUser(command.getReceiverId());
		RemoteCalledSubscriber subscriber = user.getSubscriber();
		RemoteCalledPublisher publisher = user.getPublisher();
		
		UserMetadata senderMetadata = command.getSenderMetadata();
		
		// USE CASE: SUBSCRIBE
		if(command instanceof SubscribeCommand) {
			if(command instanceof RequestSubscriptionCommand)
				publisher.addObserver(senderMetadata);
			else if(command instanceof GrantSubscriptionCommand)
				subscriber.acknowledgeSubscription(senderMetadata);
			else if(command instanceof DenySubscriptionCommand)
				subscriber.denySubscription(senderMetadata);
			else
				throw new IllegalArgumentException("cannot handle command " + command);
		}
		// USE CASE: UNSUBSCRIBE
		else if(command instanceof UnsubscribeCommand)
			publisher.deleteObserver(senderMetadata);
		else
			throw new IllegalArgumentException("cannot handle command " + command);
	}
	
}
