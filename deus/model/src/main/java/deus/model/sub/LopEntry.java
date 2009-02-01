package deus.model.sub;

import deus.model.user.UserMetadata;

public class LopEntry {

	private UserMetadata publisherMetadata;
	private SubscriptionState subscriptionState;


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public SubscriptionState getSubscriptionState() {
		return subscriptionState;
	}


	public void setSubscriptionState(SubscriptionState subscriptionState) {
		this.subscriptionState = subscriptionState;
	}
	
}
