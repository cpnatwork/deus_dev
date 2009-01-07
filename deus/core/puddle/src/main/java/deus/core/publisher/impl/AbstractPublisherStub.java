package deus.core.publisher.impl;

import deus.core.publisher.PublisherStub;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.sub.PublisherMetadata;


public abstract class AbstractPublisherStub<T extends PartyId> implements
		PublisherStub<T> {

	private PublisherMetadata<T> publisherMetadata;


	public AbstractPublisherStub(PublisherMetadata<T> publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	@Override
	public PublisherMetadata<T> getPublisherMetadata() {
		return publisherMetadata;
	}

}
