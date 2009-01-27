package deus.core.publisher.stub.local;

import deus.core.User;
import deus.core.UserRegistry;
import deus.core.publisher.RemoteCalledPublisher;
import deus.core.publisher.stub.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

public class LocalPublisherStub extends AbstractPublisherStub {

	private UserRegistry userRegistry;
	private UserId publisherId;

	public LocalPublisherStub(PublisherMetadata publisherMetadata) {
		super(publisherMetadata);
		// TODO: think about this assert
		assert (publisherMetadata.getUserId().hasTransportId(TransportIdType.local));
		
		publisherId = publisherMetadata.getUserId();
	}

	
	@Override
	public void addObserver(SubscriberMetadata subscriberMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(publisherId);
		RemoteCalledPublisher publisher = user.getPublisher();
		
		publisher.addObserver(subscriberMetadata);
	}


	@Override
	public void deleteObserver(SubscriberMetadata subscriberMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(publisherId);
		RemoteCalledPublisher publisher = user.getPublisher();
		
		publisher.deleteObserver(subscriberMetadata);
	}


}
