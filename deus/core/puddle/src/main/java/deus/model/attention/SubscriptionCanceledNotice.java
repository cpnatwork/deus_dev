package deus.model.attention;

import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public class SubscriptionCanceledNotice<Id extends UserId> extends Notice {

	private final SubscriberMetadata<Id> subscriberMetadata;
	
	public SubscriptionCanceledNotice(SubscriberMetadata<Id> subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public SubscriberMetadata<Id> getSubscriberMetadata() {
		return subscriberMetadata;
	}
	
}
