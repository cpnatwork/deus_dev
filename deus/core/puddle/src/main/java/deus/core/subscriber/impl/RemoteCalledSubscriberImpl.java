package deus.core.subscriber.impl;


import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class RemoteCalledSubscriberImpl<Id extends UserId, DifType extends DistributedInformationFolder<Id, ?>, FifContentType>
		implements RemoteCalledSubscriber<Id, FifContentType> {

	public RemoteCalledSubscriberImpl() {
		super();
	}


	@Override
	public void update(PublisherMetadata<Id> publisherMetadata, ForeignInformationFile<Id, FifContentType> fif) {
		// FIXME: how to do object change
	}

}