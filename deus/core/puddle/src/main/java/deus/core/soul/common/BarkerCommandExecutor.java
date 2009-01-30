package deus.core.soul.common;

import deus.model.user.id.UserId;

public interface BarkerCommandExecutor {

	public void grantSubscription(UserId subscriberId, UserId publisherId);


	public void denySubscription(UserId subscriberId, UserId publisherId);

}
