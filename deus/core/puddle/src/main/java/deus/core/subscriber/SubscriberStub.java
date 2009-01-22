package deus.core.subscriber;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;


public interface SubscriberStub {

	// TODO: think about Object change
	public void update(PublisherMetadata publisherMetadata, Object change);


	public SubscriberMetadata getSubscriberMetadata();

}