package deus.core.subscriber;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;


public interface SubscriberStub<Id extends UserId> {

	// TODO: think about Object change
	public void update(PublisherMetadata<Id> publisherMetadata, Object change);

	public SubscriberMetadata<Id> getSubscriberMetadata();

}