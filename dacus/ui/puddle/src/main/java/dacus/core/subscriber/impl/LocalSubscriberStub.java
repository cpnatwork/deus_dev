package dacus.core.subscriber.impl;

import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

// TODO: think about if this is needed. If it is nice to have this, remove the dependency of
// /deus-core-puddle/src/main/java/deus/core/publisher/Publisher.java from the PublisherStub interface!
// otherwise, PublisherImpl is also a PublisherStub, which is confusing!
public class LocalSubscriberStub extends AbstractSubscriberStub {

	//private RemoteCalledSubscriber subscriber;


	public LocalSubscriberStub(SubscriberMetadata subscriberMetadata) {
		super(subscriberMetadata);
		// TODO:
		//assert (subscriberMetadata.getUserId().getType().equals(UserIdType.local));
		// TODO: how to get subscriber
		//subscriber = new SubscriberImpl(subscriberMetadata);
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, Object change) {
		//subscriber.update(publisherMetadata, change);
	}


}
