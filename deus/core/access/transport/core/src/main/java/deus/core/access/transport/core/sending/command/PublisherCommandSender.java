package deus.core.access.transport.core.sending.command;

import deus.model.ifcontent.DigitalCard;
import deus.model.user.id.UserId;

public interface PublisherCommandSender {

	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard);
}
