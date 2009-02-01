package deus.core.transport.commandreceiver;

import deus.model.user.id.UserId;

public interface SubscriberCommandReceiver {

	void acknowledgeSubscription(UserId receiverId, UserId senderId);

	void denySubscription(UserId receiverId, UserId senderId);

}
