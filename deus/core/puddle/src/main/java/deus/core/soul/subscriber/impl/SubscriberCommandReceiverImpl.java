package deus.core.soul.subscriber.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.command.SubscriberCommandReceiver;
import deus.core.soul.subscriber.SubscriberExportedToPeer;
import deus.model.user.id.UserId;

//FIXME: remote this class and pass PublisherExportedToPeer as PublisherCommandReceiver
@Deprecated
@Component("subscriberCommandReceiver")
public class SubscriberCommandReceiverImpl implements SubscriberCommandReceiver {

	@Autowired
	private SubscriberExportedToPeer subscriber;

	@Override
	public void acknowledgeSubscription(UserId receiverId, UserId senderId) {
		subscriber.acknowledgeSubscription(receiverId, senderId);
	}


	@Override
	public void denySubscription(UserId receiverId, UserId senderId) {
		subscriber.denySubscription(receiverId, senderId);
	}

}
