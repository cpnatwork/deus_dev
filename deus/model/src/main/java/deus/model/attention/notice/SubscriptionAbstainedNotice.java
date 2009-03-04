package deus.model.attention.notice;

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
