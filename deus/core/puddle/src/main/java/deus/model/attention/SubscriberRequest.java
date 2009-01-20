package deus.model.attention;

import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public class SubscriberRequest<Id extends UserId> extends ConnectionDecisionToMake {

	private final SubscriberMetadata<Id> subscriberMetadata;
	
	public SubscriberRequest(SubscriberMetadata<Id> subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}

	public SubscriberMetadata<Id> getSubscriber() {
		return subscriberMetadata;
	}

		
}
