package deus.core.subscriber.impl;

import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.sub.SubscriptionState;

// TODO: add DIF
public class SubscriberImpl extends RemoteCalledSubscriberImpl implements Subscriber {

	private final SubscriberMetadata subscriberMetadata;

	

	public SubscriberImpl(SubscriberMetadata subscriberMetadata) {
		super();
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


	public void setListOfPublishers(ListOfPublishers listOfPublishers) {
		this.listOfPublishers = listOfPublishers;
	}

}
