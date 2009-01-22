package deus.core.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;


public interface Subscriber<DifType extends DistributedInformationFolder> extends RemoteCalledSubscriber {

	public DifType getDistributedInformationFolder();


	public SubscriberMetadata getSubscriberMetadata();

}