package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscriberSentNotice extends ConnectionNotice {

	private final UserMetadata subscriberMetadata;


	public SubscriberSentNotice(UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}
}
