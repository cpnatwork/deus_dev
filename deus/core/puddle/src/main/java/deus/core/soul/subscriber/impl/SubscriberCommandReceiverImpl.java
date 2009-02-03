package deus.core.soul.subscriber.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.core.transport.receiving.command.SubscriberCommandReceiver;
import deus.model.user.id.UserId;

@Component("subscriberCommandReceiver")
public class SubscriberCommandReceiverImpl implements SubscriberCommandReceiver {

	@Autowired
	public UserRegistry userRegistry;


	private RemoteCalledSubscriber getSubscriber(UserId publisherId) {
		User user = userRegistry.getOrCreateTemporaryUser(publisherId);
		return user.getSubscriber();
	}


	@Override
	public void acknowledgeSubscription(UserId receiverId, UserId senderId) {
		getSubscriber(receiverId).acknowledgeSubscription(senderId);
	}


	@Override
	public void denySubscription(UserId receiverId, UserId senderId) {
		getSubscriber(receiverId).denySubscription(senderId);
	}

}
