package deus.core.subscriber.impl;


import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;

public class RemoteCalledSubscriberImpl implements RemoteCalledSubscriber {

	public RemoteCalledSubscriberImpl() {
		super();
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile fif) {
		// FIXME: how to do object change
	}

}