package deus.model.subscription;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class LopEntry {

	private final UserId publisherId;
	private UserMetadata publisherMetadata;

	private SubscriberSideSubscriptionState subscriberSideSubscriptionState;


	public LopEntry(UserId publisherId) {
		super();
		this.publisherId = publisherId;
	}


	public UserId getPublisherId() {
		return publisherId;

	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public SubscriberSideSubscriptionState getSubscriptionState() {
		return subscriberSideSubscriptionState;
	}


	public void setSubscriptionState(SubscriberSideSubscriptionState subscriberSideSubscriptionState) {
		this.subscriberSideSubscriptionState = subscriberSideSubscriptionState;
	}

}
