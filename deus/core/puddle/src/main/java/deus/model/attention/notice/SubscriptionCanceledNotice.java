package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscriptionCanceledNotice extends SubscriberSentNotice {

	public SubscriptionCanceledNotice(UserMetadata subscriberMetadata) {
		super(subscriberMetadata);
	}


}
