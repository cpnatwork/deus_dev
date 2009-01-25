package deus.core.subscriber.impl;

import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.sub.SubscriptionState;

// TODO: add DIF
public class SubscriberImpl implements Subscriber {

	private final SubscriberMetadata subscriberMetadata;
	protected final ListOfPublishers listOfPublishers;


	public SubscriberImpl(ListOfPublishers listOfPublishers, SubscriberMetadata subscriberMetadata) {
		this.listOfPublishers = listOfPublishers;
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	@Override
	public DistributedInformationFolder getDistributedInformationFolder() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addPublisher(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState) {
		listOfPublishers.add(publisherMetadata, subscriptionState);
	}


	@Override
	public void removePublisher(PublisherMetadata publisherMetadata) {
		listOfPublishers.remove(publisherMetadata);
	}


	public ListOfPublishers getListOfPublishers() {
		return listOfPublishers;
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


	@Override
	public void denySubscription(PublisherMetadata publisherMetadata) {
		// TODO: what to do here?
	}

}
