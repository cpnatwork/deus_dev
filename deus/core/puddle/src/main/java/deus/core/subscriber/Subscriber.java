package deus.core.subscriber;

import deus.core.publisher.PublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;


public interface Subscriber<Id extends UserId> extends SubscriberStub<Id> {

	// TODO: think about Object change
	public abstract void update(PublisherStub<Id> publisher, Object change);


	public abstract SubscriberMetadata<Id> getSubscriberMetadata();

}