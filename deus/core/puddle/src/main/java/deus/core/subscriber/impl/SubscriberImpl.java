package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.Subscriber;
import deus.core.subscriber.SubscriberStub;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class SubscriberImpl<T extends PartyId> implements SubscriberStub<T>, Subscriber<T> {

	private final SubscriberMetadata<T> subscriberMetadata;


	public SubscriberImpl(SubscriberMetadata<T> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public void update(PublisherStub<T> publisher, Object change) {
		// FIXME: how to do object change
	}


	@Override
	public SubscriberMetadata<T> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}
