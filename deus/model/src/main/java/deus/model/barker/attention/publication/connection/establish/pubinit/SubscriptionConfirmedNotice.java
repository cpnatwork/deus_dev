package deus.model.barker.attention.publication.connection.establish.pubinit;

import deus.model.common.user.UserMetadata;

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
