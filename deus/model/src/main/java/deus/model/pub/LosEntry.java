package deus.model.pub;

import deus.model.user.UserMetadata;

public class LosEntry {

	private UserMetadata subscriberMetadata;


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	public void setSubscriberMetadata(UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}
}
