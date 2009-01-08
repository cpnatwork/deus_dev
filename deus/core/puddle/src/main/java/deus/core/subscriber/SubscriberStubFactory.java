package deus.core.subscriber;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public interface SubscriberStubFactory {

	public <Id extends UserId> SubscriberStub<Id> createSubscriberStub(SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata);

}
