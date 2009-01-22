package deus.model.attention;

import deus.model.pub.SubscriberMetadata;

public class SubscriptionCanceledNotice extends ConnectionNotice {

	private final SubscriberMetadata subscriberMetadata;


	public SubscriptionCanceledNotice(SubscriberMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public SubscriberMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}

}
