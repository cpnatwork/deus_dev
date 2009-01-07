package deus.core.subscriber.impl;


import deus.core.subscriber.SubscriberStub;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public abstract class AbstractSubscriberStub<T extends PartyId> implements SubscriberStub<T> {

	protected final SubscriberMetadata<T> subscriberMetadata;


	public AbstractSubscriberStub(SubscriberMetadata<T> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata<T> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}