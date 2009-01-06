package dacus.core.subscriber.impl;


import dacus.core.subscriber.SubscriberStub;
import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.SubscriberMetadata;

public abstract class AbstractSubscriberStub<T extends PartyId> implements SubscriberStub<T> {

	protected SubscriberMetadata<T> subscriberMetadata;


	public AbstractSubscriberStub(SubscriberMetadata<T> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata<T> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}