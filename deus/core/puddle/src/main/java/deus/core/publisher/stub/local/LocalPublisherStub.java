package deus.core.publisher.stub.local;

import dacus.model.user.transportid.LocalTransportId;
import deus.core.publisher.RemoteCalledPublisher;
import deus.core.publisher.stub.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.transportid.TransportIdType;

public class LocalPublisherStub extends AbstractPublisherStub {

	private final RemoteCalledPublisher publisher;

	public LocalPublisherStub(PublisherMetadata publisherMetadata) {
		super(publisherMetadata);
		// TODO: think about this assert
		assert (publisherMetadata.getUserId().hasTransportId(TransportIdType.local));
		
		LocalTransportId publisherId = getPublisherMetadata().getUserId().getTransportId(LocalTransportId.class);

		// TODO: somehow get RemoteCalledPublisher
		// publisher = userRegistry.getLocalUser(publisherId).getPublisher();
		publisher = null;		
	}

	
	@Override
	public void addObserver(SubscriberMetadata subscriberMetadata) {
		publisher.addObserver(subscriberMetadata);
	}


	@Override
	public void deleteObserver(SubscriberMetadata subscriberMetadata) {
		publisher.deleteObserver(subscriberMetadata);
	}


}
