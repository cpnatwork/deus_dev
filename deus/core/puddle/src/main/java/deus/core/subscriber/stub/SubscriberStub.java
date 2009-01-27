package deus.core.subscriber.stub;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;


public interface SubscriberStub {

	// TODO: think about Object change
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile change);


	public UserId getSubscriberId();
	

	public void acknowledgeSubscription(PublisherMetadata publisherMetadata);
	
	public void denySubscription(PublisherMetadata publisherMetadata);
	
}