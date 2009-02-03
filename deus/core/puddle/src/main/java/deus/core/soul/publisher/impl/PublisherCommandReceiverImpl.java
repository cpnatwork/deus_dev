package deus.core.soul.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.publisher.RemoteCalledPublisher;
import deus.core.transport.command.receiver.PublisherCommandReceiver;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component("publisherCommandReceiver")
public class PublisherCommandReceiverImpl implements PublisherCommandReceiver {

	@Autowired
	public UserRegistry userRegistry;


	private RemoteCalledPublisher getPublisher(UserId publisherId) {
		User user = userRegistry.getOrCreateTemporaryUser(publisherId);
		return user.getPublisher();
	}


	@Override
	public void addObserver(UserId receiverId, UserId senderId, UserMetadata subscriberMetadata) {
		getPublisher(receiverId).addObserver(senderId, subscriberMetadata);
	}


	@Override
	public void deleteObserver(UserId receiverId, UserId senderId) {
		getPublisher(receiverId).deleteObserver(senderId);
	}

}
