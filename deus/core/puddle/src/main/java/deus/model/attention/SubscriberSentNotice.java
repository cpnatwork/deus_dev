package deus.model.attention;

import deus.model.pub.SubscriberMetadata;

public class SubscriberSentNotice extends ConnectionNotice {

	private final SubscriberMetadata subscriberMetadata;


	public SubscriberSentNotice(SubscriberMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public SubscriberMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}
}
