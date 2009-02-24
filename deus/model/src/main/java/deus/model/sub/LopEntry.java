package deus.model.sub;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class LopEntry {

	private UserId publisherId;
	private UserMetadata publisherMetadata;

	private RequestedSubscriptionState requestedSubscriptionState;


	public UserId getPublisherId() {
		return publisherId;
		
	}


	public void setPublisherId(UserId publisherId) {
		this.publisherId = publisherId;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public RequestedSubscriptionState getSubscriptionState() {
		return requestedSubscriptionState;
	}


	public void setSubscriptionState(RequestedSubscriptionState requestedSubscriptionState) {
		this.requestedSubscriptionState = requestedSubscriptionState;
	}

}
