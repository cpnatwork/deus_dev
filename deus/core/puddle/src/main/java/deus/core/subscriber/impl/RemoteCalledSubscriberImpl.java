package deus.core.subscriber.impl;


import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;

public class RemoteCalledSubscriberImpl<DifType extends DistributedInformationFolder<?>, FifContentType> implements
		RemoteCalledSubscriber<FifContentType> {

	public RemoteCalledSubscriberImpl() {
		super();
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile<FifContentType> fif) {
		// FIXME: how to do object change
	}

}