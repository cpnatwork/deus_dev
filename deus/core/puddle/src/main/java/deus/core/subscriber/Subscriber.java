package deus.core.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.sub.SubscriptionState;


public interface Subscriber extends RemoteCalledSubscriber {

	public DistributedInformationFolder getDistributedInformationFolder();


	public SubscriberMetadata getSubscriberMetadata();

	

	public void addPublisher(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState);


	public void removePublisher(PublisherMetadata publisherMetadata);

}