package deus.core.subscriber.stub;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;


public interface SubscriberStub {

	// TODO: think about Object change
	public void update(UserMetadata publisherMetadata, ForeignInformationFile change);


	public UserId getSubscriberId();
	

	public void acknowledgeSubscription(UserMetadata publisherMetadata);
	
	public void denySubscription(UserMetadata publisherMetadata);
	
}