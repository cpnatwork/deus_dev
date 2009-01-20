package deus.model.attention;

import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public class SubscriberRequest<Id extends UserId> extends ConnectionDecisionToMake {

	private final SubscriberMetadata<Id> subscriber;
	
	public SubscriberRequest(SubscriberMetadata<Id> subscriber) {
		this.subscriber = subscriber;
	}

	public SubscriberMetadata<Id> getSubscriber() {
		return subscriber;
	}

		
}
