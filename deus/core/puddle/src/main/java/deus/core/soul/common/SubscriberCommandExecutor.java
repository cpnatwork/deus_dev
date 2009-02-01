package deus.core.soul.common;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public interface SubscriberCommandExecutor {

	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata subscriberMetadata);


	public void unsubscribe(UserId subscriberId, UserId publisherId);
	
}
