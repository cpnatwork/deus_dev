package deus.core.soul.subscriber.stub.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.User;
import deus.core.soul.UserRegistry;
import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.core.soul.subscriber.stub.impl.AbstractSubscriberStub;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

// TODO: think about if this is needed. If it is nice to have this, remove the dependency of
// /deus-core-puddle/src/main/java/deus/core/publisher/Publisher.java from the PublisherStub interface!
// otherwise, PublisherImpl is also a PublisherStub, which is confusing!
// TODO: think about @Configurable and @Autowired with userRegistry
@Configurable
public class LocalSubscriberStub extends AbstractSubscriberStub {

	@Autowired
	private UserRegistry userRegistry;

	public LocalSubscriberStub(UserId subscriberId) {
		super(subscriberId);
		// TODO: think about this assert
		assert (subscriberId.hasTransportId(TransportIdType.local));
	}


	@Override
	public void update(UserMetadata publisherMetadata, ForeignInformationFile change) {
		User user = userRegistry.getOrCreateTemporaryUser(getSubscriberId());
		RemoteCalledSubscriber subscriber = user.getSubscriber();
		
		subscriber.update(publisherMetadata, change);
	}


	@Override
	public void acknowledgeSubscription(UserMetadata publisherMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(getSubscriberId());
		RemoteCalledSubscriber subscriber = user.getSubscriber();

		subscriber.acknowledgeSubscription(publisherMetadata);
	}


	@Override
	public void denySubscription(UserMetadata publisherMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(getSubscriberId());
		RemoteCalledSubscriber subscriber = user.getSubscriber();

		subscriber.denySubscription(publisherMetadata);		
	}

}
