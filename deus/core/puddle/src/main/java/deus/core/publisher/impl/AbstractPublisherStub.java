package deus.core.publisher.impl;

import deus.core.publisher.PublisherStub;
import deus.model.sub.PublisherMetadata;


public abstract class AbstractPublisherStub implements PublisherStub {

	private PublisherMetadata publisherMetadata;


	public AbstractPublisherStub(PublisherMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	@Override
	public PublisherMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}
