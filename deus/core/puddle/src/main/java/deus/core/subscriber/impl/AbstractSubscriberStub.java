package deus.core.subscriber.impl;


import deus.core.subscriber.SubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public abstract class AbstractSubscriberStub<Id extends UserId> implements SubscriberStub<Id> {

	private final SubscriberMetadata<Id> subscriberMetadata;


	public AbstractSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata<Id> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}