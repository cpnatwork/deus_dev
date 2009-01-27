package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscriptionDeniedNotice extends PublisherSentNotice {

	public SubscriptionDeniedNotice(UserMetadata publiserMetadata) {
		super(publiserMetadata);
	}

	@Override
	public String getCatchphare() {
		//I18N
		return "Your subscription request to "+getPublisherMetadata().getFullName()+" has been denied";
	}

}
