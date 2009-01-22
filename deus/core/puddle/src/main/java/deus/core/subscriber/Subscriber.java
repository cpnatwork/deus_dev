package deus.core.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;


public interface Subscriber extends RemoteCalledSubscriber {

	public DistributedInformationFolder getDistributedInformationFolder();


	public SubscriberMetadata getSubscriberMetadata();

}