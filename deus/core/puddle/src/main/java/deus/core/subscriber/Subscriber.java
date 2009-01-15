package deus.core.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;


public interface Subscriber<Id extends UserId, DifContentType> {


	// TODO: think about Object change
	public void update(PublisherMetadata<Id> publisherMetadata, Object change);


	public DistributedInformationFolder<Id, DifContentType> getDistributedInformationFolder();
	
	
	public SubscriberMetadata<Id> getSubscriberMetadata();

}