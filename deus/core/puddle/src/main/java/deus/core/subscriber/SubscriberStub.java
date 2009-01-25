package deus.core.subscriber;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;


public interface SubscriberStub {

	// TODO: think about Object change
	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile change);


	public SubscriberMetadata getSubscriberMetadata();
	

	public void acknowledgeSubscription(PublisherMetadata publisherMetadata);
	
	public void denySubscription(PublisherMetadata publisherMetadata);
	
}