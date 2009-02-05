package deus.core.access.transport.core.sending.command;

import deus.model.user.id.UserId;

public interface BarkerCommandSender {

	public void grantSubscription(UserId subscriberId, UserId publisherId);


	public void denySubscription(UserId subscriberId, UserId publisherId);

}
