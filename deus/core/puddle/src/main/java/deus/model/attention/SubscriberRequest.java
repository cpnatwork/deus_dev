package deus.model.attention;

import deus.model.pub.SubscriberMetadata;

public class SubscriberRequest extends ConnectionDecisionToMake {

	private final SubscriberMetadata subscriberMetadata;


	public SubscriberRequest(SubscriberMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public SubscriberMetadata getSubscriber() {
		return subscriberMetadata;
	}


}
