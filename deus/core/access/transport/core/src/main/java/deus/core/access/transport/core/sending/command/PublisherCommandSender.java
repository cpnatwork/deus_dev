package deus.core.access.transport.core.sending.command;

import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public interface PublisherCommandSender {

	// USE CASE: update
	
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard);

	
	// USE CASE: publisher initiated connection/termination

	public void offerSubscription(UserId publisherId, UserId subscriberId, UserMetadata publisherMetadata);

	public void cancelSubscription(UserId publisherId, UserId subscriberId);
	
}
