package deus.core.transport.command.sender;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public interface SubscriberCommandSender {

	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata subscriberMetadata);


	public void unsubscribe(UserId subscriberId, UserId publisherId);
	
}
