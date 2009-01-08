package deus.core.publisher.impl;

import deus.core.publisher.PublisherStub;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;


public abstract class AbstractPublisherStub<Id extends UserId> implements
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
