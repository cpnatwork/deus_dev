package deus.core.transport.receiving.command;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public interface PublisherCommandReceiver {

	void addObserver(UserId receiverId, UserId senderId, UserMetadata senderMetadata);

	void deleteObserver(UserId receiverId, UserId senderId);

}
