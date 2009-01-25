package deus.core.subscriber.impl;

import deus.core.subscriber.RemoteCalledSubscriber;
import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.sub.SubscriptionState;

public class RemoteCalledSubscriberToSubscriberAdapter implements Subscriber {

	private final RemoteCalledSubscriber remoteCalledSubscriber;
	private final Subscriber subscriber;


	public RemoteCalledSubscriberToSubscriberAdapter(RemoteCalledSubscriber remoteCalledSubscriber,
			Subscriber subscriber) {
		super();
		this.remoteCalledSubscriber = remoteCalledSubscriber;
		this.subscriber = subscriber;
	}

//	+++ METHODS OF REMOTE CALLED SUBSCRIBER ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void acknowledgeSubscription(PublisherMetadata publisherMetadata) {
		remoteCalledSubscriber.acknowledgeSubscription(publisherMetadata);
	}


	@Override
	public void denySubscription(PublisherMetadata publisherMetadata) {
		remoteCalledSubscriber.denySubscription(publisherMetadata);
	}


	@Override
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile fif) {
		remoteCalledSubscriber.update(publisherMetadata, fif);
	}


	
//	+++ METHODS OF SUBSCRIBER ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void addPublisher(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState) {
		subscriber.addPublisher(publisherMetadata, subscriptionState);
	}


	@Override
	public DistributedInformationFolder getDistributedInformationFolder() {
		return subscriber.getDistributedInformationFolder();
	}


	@Override
	public SubscriberMetadata getSubscriberMetadata() {
		return subscriber.getSubscriberMetadata();
	}


	@Override
	public void removePublisher(PublisherMetadata publisherMetadata) {
		subscriber.removePublisher(publisherMetadata);
	}

}
