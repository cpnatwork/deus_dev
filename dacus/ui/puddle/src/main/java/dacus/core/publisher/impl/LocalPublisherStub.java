package dacus.core.publisher.impl;

import dacus.core.publisher.Publisher;
import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.SubscriberMetadata;
import dacus.model.sub.PublisherMetadata;

public class LocalPublisherStub<T extends PartyId> extends AbstractPublisherStub<T> {

	private Publisher<T> publisher;


	public LocalPublisherStub(PublisherMetadata<T> publisherMetadata) {
		super(publisherMetadata);
	}

	
	@Override
	public void addObserver(SubscriberMetadata<T> subscriberMetadata) {
		// FIXME: get publisher using publisherMetadata		
		publisher.addObserver(subscriberMetadata);
	}


	@Override
	public void notifyObservers() {
		// FIXME: get publisher using publisherMetadata		
		publisher.notifyObservers();
	}

}
