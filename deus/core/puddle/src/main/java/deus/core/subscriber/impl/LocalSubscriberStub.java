package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.Subscriber;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class LocalSubscriberStub<T extends PartyId> extends AbstractSubscriberStub<T>  {

	private Subscriber<T> subscriber;

	
	public LocalSubscriberStub(SubscriberMetadata<T> subscriberMetadata) {
		super(subscriberMetadata);
	}
	
	@Override
	public void update(PublisherStub<T> publisher, Object change) {
		// FIXME: get subscriber using subscriberMetadata
		subscriber.update(publisher, change);
	}


}
