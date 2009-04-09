package deus.model.subscription;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;

public class LopEntry {

	private final PublisherId publisherId;
	private UserMetadata publisherMetadata;

	private SubscriberSideSubscriptionState subscriberSideSubscriptionState;


	public LopEntry(PublisherId publisherId) {
		super();
		this.publisherId = publisherId;
	}


	public PublisherId getPublisherId() {
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
