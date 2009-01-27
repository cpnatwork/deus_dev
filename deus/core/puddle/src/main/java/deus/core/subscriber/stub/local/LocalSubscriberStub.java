package deus.core.subscriber.stub.local;

import deus.core.User;
import deus.core.UserRegistry;
import deus.core.subscriber.RemoteCalledSubscriber;
import deus.core.subscriber.stub.impl.AbstractSubscriberStub;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

// TODO: think about if this is needed. If it is nice to have this, remove the dependency of
// /deus-core-puddle/src/main/java/deus/core/publisher/Publisher.java from the PublisherStub interface!
// otherwise, PublisherImpl is also a PublisherStub, which is confusing!
// TODO: think about @Configurable and @Autowired with userRegistry
public class LocalSubscriberStub extends AbstractSubscriberStub {

	private UserRegistry userRegistry;
	private UserId subscriberId;


	public LocalSubscriberStub(SubscriberMetadata subscriberMetadata) {
		super(subscriberMetadata);
		// TODO: think about this assert
		assert (subscriberMetadata.getUserId().getType().equals(TransportIdType.local));
		
		subscriberId = getSubscriberMetadata().getUserId();
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile change) {
		User user = userRegistry.getOrCreateTemporaryUser(subscriberId);
		RemoteCalledSubscriber subscriber = user.getSubscriber();
		
		subscriber.update(publisherMetadata, change);
	}


	@Override
	public void acknowledgeSubscription(PublisherMetadata publisherMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(subscriberId);
		RemoteCalledSubscriber subscriber = user.getSubscriber();

		subscriber.acknowledgeSubscription(publisherMetadata);
	}


	@Override
	public void denySubscription(PublisherMetadata publisherMetadata) {
		User user = userRegistry.getOrCreateTemporaryUser(subscriberId);
		RemoteCalledSubscriber subscriber = user.getSubscriber();

		subscriber.denySubscription(publisherMetadata);		
	}

}
