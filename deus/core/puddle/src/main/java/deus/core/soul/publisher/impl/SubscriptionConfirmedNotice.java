package deus.core.soul.publisher.impl;

import deus.model.attention.notice.PublisherInitiatedConnectionNotice;
import deus.model.user.UserMetadata;

public class SubscriptionConfirmedNotice extends PublisherInitiatedConnectionNotice {

	public SubscriptionConfirmedNotice(UserMetadata subscriberMetadata) {
		super(subscriberMetadata);
	}


	@Override
	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}
