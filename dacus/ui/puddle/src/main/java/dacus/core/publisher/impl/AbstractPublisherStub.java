package dacus.core.publisher.impl;

import dacus.core.publisher.PublisherStub;
import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.sub.PublisherMetadata;


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
