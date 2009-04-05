package deus.model.attention.publication.connection.establish.subinit;

import deus.model.user.UserMetadata;

public class SubscriptionRequestGrantedNotice extends SubscriberInitiatedConnectionNotice {

	public SubscriptionRequestGrantedNotice(UserMetadata publisherMetadata) {
		super(publisherMetadata);
	}

	@Override
	public String getCatchphare() {
		//I18N
		return "Your subscription request to "+getPublisherMetadata().getFullName()+" has been established";
	}


}
