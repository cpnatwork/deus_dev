package deus.model.publication;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class LosEntry {

	private final UserId ownerId;

	private UserId subscriberId;
	private UserMetadata subscriberMetadata;

	private PublisherSideSubscriptionState publisherSideSubscriptionState;


	// TODO: insert SHARE SET here!


	public LosEntry(UserId ownerId) {
		super();
		this.ownerId = ownerId;
	}


	/**
	 * Returns the ID of the owner of this LosEntry. The owner is the publisher owning the list of subscribers.
	 */
	public UserId getOwnerId() {
		return ownerId;
	}


	public UserId getSubscriberId() {
		return subscriberId;
	}


	public void setSubscriberId(UserId subscriberId) {
		this.subscriberId = subscriberId;
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
