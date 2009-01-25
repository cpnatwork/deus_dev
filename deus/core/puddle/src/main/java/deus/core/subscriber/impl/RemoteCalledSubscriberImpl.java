package deus.core.subscriber.impl;


import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.sub.SubscriptionState;

public abstract class RemoteCalledSubscriberImpl implements RemoteCalledSubscriber {

	protected ListOfPublishers listOfPublishers;


	public RemoteCalledSubscriberImpl() {
		super();
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile fif) {
		if (!listOfPublishers.contains(publisherMetadata))
			// FIXME: how to handle this??
			;
		// FIXME: how to do object change
	}


	@Override
	public void acknowledgeSubscription(PublisherMetadata publisherMetadata) {
		listOfPublishers.changeState(publisherMetadata, SubscriptionState.granted);
	}

}