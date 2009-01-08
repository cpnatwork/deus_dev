package deus.core.subscriber;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;

public interface SubscriberStubFactory {

	public <Id extends UserId> SubscriberStub<Id> createSubscriberStub(SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata);

	public boolean canHandle(UserIdType userIdType);
}
