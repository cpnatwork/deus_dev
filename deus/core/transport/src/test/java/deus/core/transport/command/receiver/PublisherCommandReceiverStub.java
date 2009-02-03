package deus.core.transport.command.receiver;

import org.springframework.stereotype.Component;

import deus.core.transport.command.receiver.PublisherCommandReceiver;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
public class PublisherCommandReceiverStub implements PublisherCommandReceiver {

	@Override
	public void addObserver(UserId receiverId, UserId senderId, UserMetadata senderMetadata) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObserver(UserId receiverId, UserId senderId) {
		// TODO Auto-generated method stub
		
	}

}
