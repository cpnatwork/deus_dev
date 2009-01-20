package deus.core.subscriber.impl;


import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class RemoteCalledSubscriberImpl<Id extends UserId, DifType extends DistributedInformationFolder<Id, ?>>
		implements RemoteCalledSubscriber<Id> {

	public RemoteCalledSubscriberImpl() {
		super();
	}


	@Override
	public void update(PublisherMetadata<Id> publisherMetadata, Object change) {
		// FIXME: how to do object change
	}

}