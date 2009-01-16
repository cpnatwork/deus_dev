package deus.core.subscriber;

import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public interface RemoteCalledSubscriber<Id extends UserId> {


	// TODO: think about Object change
	public void update(PublisherMetadata<Id> publisherMetadata, Object change);


}
