package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscriptionDeniedNotice extends SubscriberInitiatedConnectionNotice {

	public SubscriptionDeniedNotice(UserMetadata publisherMetadata) {
		super(publisherMetadata);
	}

	@Override
	public String getCatchphare() {
		//I18N
		return "Your subscription request to "+getPublisherMetadata().getFullName()+" has been denied";
	}

}
