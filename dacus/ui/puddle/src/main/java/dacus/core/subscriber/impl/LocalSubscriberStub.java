package dacus.core.subscriber.impl;

import dacus.core.publisher.PublisherStub;
import dacus.core.subscriber.Subscriber;
import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.SubscriberMetadata;

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
