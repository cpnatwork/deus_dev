package deus.core.subscriber.impl;


import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;

public class RemoteCalledSubscriberImpl<DifType extends DistributedInformationFolder> implements
		RemoteCalledSubscriber {

	public RemoteCalledSubscriberImpl() {
		super();
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile fif) {
		// FIXME: how to do object change
	}

}