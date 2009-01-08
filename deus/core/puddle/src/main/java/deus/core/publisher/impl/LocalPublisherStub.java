package deus.core.publisher.impl;

import deus.core.publisher.Publisher;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class LocalPublisherStub<Id extends UserId> extends AbstractPublisherStub<Id> {

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
