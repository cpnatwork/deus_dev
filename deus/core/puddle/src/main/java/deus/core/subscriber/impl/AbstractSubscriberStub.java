package deus.core.subscriber.impl;


import deus.core.subscriber.SubscriberStub;
import deus.model.pub.SubscriberMetadata;

public abstract class AbstractSubscriberStub implements SubscriberStub {

	private final SubscriberMetadata subscriberMetadata;


	public AbstractSubscriberStub(SubscriberMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}

}