package deus.core.access.transport.core.sending.command;

import deus.model.user.id.UserId;

public interface BarkerCommandSender {

	// USE CASE: publisher initiated connection (used, when in role subscriber)
	
	// FIXME: rename to confirm
	public void confirmSubscription(UserId subscriberId, UserId publisherId);


	public void abstainSubscription(UserId subscriberId, UserId publisherId);

}
