package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscriptionDeniedNotice extends PublisherSentNotice {

	public SubscriptionDeniedNotice(UserMetadata publiserMetadata) {
		super(publiserMetadata);
	}

}
