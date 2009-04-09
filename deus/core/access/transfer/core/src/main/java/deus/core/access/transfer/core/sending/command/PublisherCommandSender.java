package deus.core.access.transfer.core.sending.command;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

// FIXME: rename to publicationCommandSender in order to reflect subsystem
public interface PublisherCommandSender {

	// USE CASE: update
	
	public void update(PublisherId publisherId, SubscriberId subscriberId, DigitalCard digitalCard);

	
	// USE CASE: publisher initiated connection/termination

	public void offerSubscription(PublisherId publisherId, SubscriberId subscriberId, UserMetadata publisherMetadata);

	public void cancelSubscription(PublisherId publisherId, SubscriberId subscriberId);

	

	// USE CASE: informationConsumer initiated connection (used, when in role publisher)
	
	public void grantSubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId);


	public void denySubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId);
	
}
