package dacus.core.publisher.impl;

import deus.core.publisher.RemoteCalledPublisher;
import deus.core.publisher.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

public class LocalPublisherStub extends AbstractPublisherStub {


	public LocalPublisherStub(PublisherMetadata publisherMetadata) {
		super(publisherMetadata);
		// TODO:
		//assert(publisherMetadata.getUserId().getType().equals(UserIdType.local));
	}

	
	@Override
	public void addObserver(SubscriberMetadata subscriberMetadata) {
		// TODO: how to get publisher?
		//RemoteCalledPublisher publisher = new RemoteCalledPublisherImpl(getPublisherMetadata());
		RemoteCalledPublisher publisher = null;
		publisher.addObserver(subscriberMetadata);
	}


	@Override
	public void deleteObserver(SubscriberMetadata subscriberMetadata) {
		// TODO: how to get publisher?
		//RemoteCalledPublisher publisher = new RemoteCalledPublisherImpl(getPublisherMetadata());
		RemoteCalledPublisher publisher = null;
		publisher.deleteObserver(subscriberMetadata);
	}


}
