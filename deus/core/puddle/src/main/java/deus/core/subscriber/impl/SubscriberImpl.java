package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.Subscriber;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public class SubscriberImpl<Id extends UserId> implements Subscriber<Id> {

	private final SubscriberMetadata<Id> subscriberMetadata;


	public SubscriberImpl(SubscriberMetadata<Id> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public void update(PublisherStub<Id> publisher, Object change) {
		// FIXME: how to do object change
	}


	@Override
	public SubscriberMetadata<Id> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}
