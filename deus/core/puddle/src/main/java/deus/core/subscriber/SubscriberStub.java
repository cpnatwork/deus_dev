package deus.core.subscriber;

import deus.core.publisher.PublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;


public interface SubscriberStub<Id extends UserId> {

	// TODO: think about Object o
	public void update(PublisherStub<Id> publisher, Object change);

	public SubscriberMetadata<Id> getSubscriberMetadata();

}