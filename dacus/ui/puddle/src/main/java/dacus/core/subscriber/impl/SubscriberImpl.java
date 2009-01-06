package dacus.core.subscriber.impl;

import dacus.core.publisher.PublisherStub;
import dacus.core.subscriber.Subscriber;
import dacus.core.subscriber.SubscriberStub;
import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.SubscriberMetadata;

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
