package deus.core.publisher.impl;

import deus.core.publisher.PublisherStub;
import deus.model.dossier.proj.party.PartyId;
import deus.model.sub.PublisherMetadata;


public abstract class AbstractPublisherStub<Id extends PartyId> implements
		PublisherStub<Id> {

	private PublisherMetadata<Id> publisherMetadata;


	public AbstractPublisherStub(PublisherMetadata<Id> publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	@Override
	public PublisherMetadata<Id> getPublisherMetadata() {
		return publisherMetadata;
	}

}
