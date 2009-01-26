package deus.core.subscriber.stub.local;

import dacus.model.user.transportid.LocalTransportId;
import deus.core.subscriber.RemoteCalledSubscriber;
import deus.core.subscriber.stub.impl.AbstractSubscriberStub;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.transportid.TransportIdType;

// TODO: think about if this is needed. If it is nice to have this, remove the dependency of
// /deus-core-puddle/src/main/java/deus/core/publisher/Publisher.java from the PublisherStub interface!
// otherwise, PublisherImpl is also a PublisherStub, which is confusing!
public class LocalSubscriberStub extends AbstractSubscriberStub {

	private RemoteCalledSubscriber subscriber;


	public LocalSubscriberStub(SubscriberMetadata subscriberMetadata) {
		super(subscriberMetadata);
		// TODO: think about this assert
		assert (subscriberMetadata.getUserId().getType().equals(TransportIdType.local));
		
		LocalTransportId subscriberId = getSubscriberMetadata().getUserId().getTransportId(LocalTransportId.class);

		
		// TODO: how to get RemoteCalledSubscriber
		// subscriber = userRegistry.getLocalUser(subscriberId).getSubscriber();
		subscriber = null;		
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile change) {
		subscriber.update(publisherMetadata, change);
	}


	@Override
	public void acknowledgeSubscription(PublisherMetadata publisherMetadata) {
		subscriber.acknowledgeSubscription(publisherMetadata);
	}


	@Override
	public void denySubscription(PublisherMetadata publisherMetadata) {
		subscriber.denySubscription(publisherMetadata);		
	}

}
