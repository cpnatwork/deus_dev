package deus.core.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.sub.SubscriptionState;

/**
 * Central facade of the subscriber subsystem.
 * 
 * Methods from the interface <code>RemoteCalledSubscriber</code> are called remotely on this subscriber. The other
 * methods of this interface are methods to retrieve information about the subscriber subsystem locally.
 * 
 * @see RemoteCalledSubscriber
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface Subscriber extends RemoteCalledSubscriber {

	public DistributedInformationFolder getDistributedInformationFolder();


	public SubscriberMetadata getSubscriberMetadata();


	public void addPublisher(PublisherMetadata publisherMetadata, SubscriptionState subscriptionState);


	public void removePublisher(PublisherMetadata publisherMetadata);

}