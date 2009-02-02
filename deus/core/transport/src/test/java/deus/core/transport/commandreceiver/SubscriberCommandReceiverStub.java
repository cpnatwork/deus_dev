package deus.core.transport.commandreceiver;

import org.springframework.stereotype.Component;

import deus.model.user.id.UserId;

@Component
public class SubscriberCommandReceiverStub implements SubscriberCommandReceiver {

	@Override
	public void acknowledgeSubscription(UserId receiverId, UserId senderId) {
		// TODO Auto-generated method stub

	}


	@Override
	public void denySubscription(UserId receiverId, UserId senderId) {
		// TODO Auto-generated method stub

	}

}
