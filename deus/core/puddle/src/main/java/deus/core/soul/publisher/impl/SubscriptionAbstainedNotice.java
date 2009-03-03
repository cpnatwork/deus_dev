package deus.core.soul.publisher.impl;

import deus.model.attention.notice.PublisherInitiatedConnectionNotice;
import deus.model.user.UserMetadata;

public class SubscriptionAbstainedNotice extends PublisherInitiatedConnectionNotice {

	public SubscriptionAbstainedNotice(UserMetadata subscriberMetadata) {
		super(subscriberMetadata);
	}
	


	@Override
	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}
