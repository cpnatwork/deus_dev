package deus.model.pub;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class LosEntry {

	private final UserId ownerId;

	private UserMetadata subscriberMetadata;

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


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	public void setSubscriberMetadata(UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}
}
