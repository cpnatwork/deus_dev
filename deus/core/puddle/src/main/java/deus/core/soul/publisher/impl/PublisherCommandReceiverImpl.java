package deus.core.soul.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.command.PublisherCommandReceiver;
import deus.core.soul.publisher.PublisherExportedToPeer;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

// FIXME: remote this class and pass PublisherExportedToPeer as PublisherCommandReceiver
@Deprecated
@Component("publisherCommandReceiver")
public class PublisherCommandReceiverImpl implements PublisherCommandReceiver {

	@Autowired
	public PublisherExportedToPeer publisher;

	@Override
	public void addObserver(UserId receiverId, UserId senderId, UserMetadata subscriberMetadata) {
		publisher.addSubscriber(receiverId, senderId, subscriberMetadata);
	}


	@Override
	public void deleteObserver(UserId receiverId, UserId senderId) {
		publisher.deleteSubscriber(receiverId, senderId);
	}

}
