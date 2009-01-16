package deus.core.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;


public interface Subscriber<Id extends UserId, DifType extends DistributedInformationFolder<Id, ?>> extends RemoteCalledSubscriber<Id> {

	public DifType getDistributedInformationFolder();


	public SubscriberMetadata<Id> getSubscriberMetadata();

}