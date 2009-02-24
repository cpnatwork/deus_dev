package deus.model.sub;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class LopEntry {

	private UserId ownerId;
	
	private UserMetadata publisherMetadata;
	private RequestedSubscriptionState requestedSubscriptionState;
	
	
	public LopEntry(UserId ownerId) {
		super();
		this.ownerId = ownerId;
	}


	/**
	 * Returns the ID of the owner of this LopEntry. The owner is the subscriber owning the list of publishers.
	 */
	public UserId getOwnerId() {
		return ownerId;
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
