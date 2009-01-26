package deus.core.subscriber.stub.impl;


import deus.core.subscriber.stub.SubscriberStub;
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