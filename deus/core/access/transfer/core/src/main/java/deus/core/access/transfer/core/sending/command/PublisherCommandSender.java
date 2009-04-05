package deus.core.access.transfer.core.sending.command;

import deus.model.dossier.DigitalCard;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

// FIXME: rename to publicationCommandSender in order to reflect subsystem
public interface PublisherCommandSender {

	// USE CASE: update
	
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard);

	
	// USE CASE: publisher initiated connection/termination

	public void offerSubscription(UserId publisherId, UserId subscriberId, UserMetadata publisherMetadata);

	public void cancelSubscription(UserId publisherId, UserId subscriberId);

	

	// USE CASE: informationConsumer initiated connection (used, when in role publisher)
	
	public void grantSubscriptionRequest(UserId publisherId, UserId subscriberId);


	public void denySubscriptionRequest(UserId publisherId, UserId subscriberId);
	
}
