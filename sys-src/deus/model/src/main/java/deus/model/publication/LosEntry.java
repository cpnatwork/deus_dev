package deus.model.publication;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.SubscriberId;

/**
 * An entry in the list of subscribers.
 * 
 * The primary key is the ID of the publisher who owns the list and the ID of the subscriber who is embodied by the list
 * entry. Only the latter is included in the entity, since this is the discriminator of the weak entity.
 * 
 * 
 * @see ListOfSubscribers
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class LosEntry {

	private final SubscriberId subscriberId;
	private UserMetadata subscriberMetadata;

	private PublisherSideSubscriptionState publisherSideSubscriptionState;


	public LosEntry(SubscriberId subscriberId) {
		this.subscriberId = subscriberId;
	}


	public SubscriberId getSubscriberId() {
		return subscriberId;
	}


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	public void setSubscriberMetadata(UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public PublisherSideSubscriptionState getSubscriptionState() {
		return publisherSideSubscriptionState;
	}


	public void setSubscriptionState(PublisherSideSubscriptionState publisherSideSubscriptionState) {
		this.publisherSideSubscriptionState = publisherSideSubscriptionState;
	}

}
