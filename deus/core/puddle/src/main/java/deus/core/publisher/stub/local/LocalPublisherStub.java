package deus.core.publisher.stub.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.User;
import deus.core.UserRegistry;
import deus.core.publisher.RemoteCalledPublisher;
import deus.core.publisher.stub.impl.AbstractPublisherStub;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

@Configurable
public class LocalPublisherStub extends AbstractPublisherStub {

	@Autowired
	private UserRegistry userRegistry;

	public LocalPublisherStub(UserId publisherId) {
		super(publisherId);
		// TODO: think about this assert
		assert (publisherId.hasTransportId(TransportIdType.local));
	}

	
	@Override
	public void addObserver(UserMetadata subscriberMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(getPublisherId());
		RemoteCalledPublisher publisher = user.getPublisher();
		
		publisher.addObserver(subscriberMetadata);
	}


	@Override
	public void deleteObserver(UserMetadata subscriberMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(getPublisherId());
		RemoteCalledPublisher publisher = user.getPublisher();
		
		publisher.deleteObserver(subscriberMetadata);
	}


}
