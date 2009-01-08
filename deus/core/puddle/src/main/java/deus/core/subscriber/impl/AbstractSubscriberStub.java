package deus.core.subscriber.impl;


import deus.core.subscriber.SubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public abstract class AbstractSubscriberStub<Id extends UserId> implements SubscriberStub<Id> {

	protected final SubscriberMetadata<Id> subscriberMetadata;


	public AbstractSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata<Id> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}