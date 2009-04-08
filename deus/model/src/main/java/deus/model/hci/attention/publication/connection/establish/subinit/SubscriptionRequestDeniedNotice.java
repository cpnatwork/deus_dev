package deus.model.hci.attention.publication.connection.establish.subinit;

import deus.model.common.user.UserMetadata;

public class SubscriptionRequestDeniedNotice extends SubscriberInitiatedConnectionNotice {

	public SubscriptionRequestDeniedNotice(UserMetadata publisherMetadata) {
		super(publisherMetadata);
	}

	@Override
	public String getCatchphare() {
		//I18N
		return "Your subscription request to "+getPublisherMetadata().getFullName()+" has been denied";
	}

}
