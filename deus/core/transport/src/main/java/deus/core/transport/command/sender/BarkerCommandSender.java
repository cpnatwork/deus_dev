package deus.core.transport.command.sender;

import deus.model.user.id.UserId;

public interface BarkerCommandSender {

	public void grantSubscription(UserId subscriberId, UserId publisherId);


	public void denySubscription(UserId subscriberId, UserId publisherId);

}
