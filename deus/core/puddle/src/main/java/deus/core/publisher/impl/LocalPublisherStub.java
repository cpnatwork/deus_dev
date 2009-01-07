package deus.core.publisher.impl;

import deus.core.publisher.Publisher;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

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
	public void deleteObserver(SubscriberMetadata<T> subscriberMetadata) {
		// FIXME: get publisher using publisherMetadata
		publisher.deleteObserver(subscriberMetadata);
	}


}
