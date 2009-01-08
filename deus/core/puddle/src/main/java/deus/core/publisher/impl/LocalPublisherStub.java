package deus.core.publisher.impl;

import deus.core.publisher.Publisher;
import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

public class LocalPublisherStub<Id extends PartyId> extends AbstractPublisherStub<Id> {

	private Publisher<Id> publisher;


	public LocalPublisherStub(PublisherMetadata<Id> publisherMetadata) {
		super(publisherMetadata);
	}

	
	@Override
	public void addObserver(SubscriberMetadata<Id> subscriberMetadata) {
		// FIXME: get publisher using publisherMetadata		
		publisher.addObserver(subscriberMetadata);
	}


	@Override
	public void deleteObserver(SubscriberMetadata<Id> subscriberMetadata) {
		// FIXME: get publisher using publisherMetadata
		publisher.deleteObserver(subscriberMetadata);
	}


}
