package deus.core.subscriber;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;

public interface SubscriberStubFactory<Id extends UserId> {

	public  SubscriberStub<Id> createSubscriberStub(SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata);

	public boolean canHandle(UserIdType userIdType);
}
