package deus.core.publisher.stub.local;

import deus.core.User;
import deus.core.UserRegistry;
import deus.core.publisher.RemoteCalledPublisher;
import deus.core.publisher.stub.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

public class LocalPublisherStub extends AbstractPublisherStub {

	private UserRegistry userRegistry;

	public LocalPublisherStub(UserId publisherId) {
		super(publisherId);
		// TODO: think about this assert
		assert (publisherId.hasTransportId(TransportIdType.local));
	}

	
	@Override
	public void addObserver(SubscriberMetadata subscriberMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(getPublisherId());
		RemoteCalledPublisher publisher = user.getPublisher();
		
		publisher.addObserver(subscriberMetadata);
	}


	@Override
	public void deleteObserver(SubscriberMetadata subscriberMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(getPublisherId());
		RemoteCalledPublisher publisher = user.getPublisher();
		
		publisher.deleteObserver(subscriberMetadata);
	}


}
