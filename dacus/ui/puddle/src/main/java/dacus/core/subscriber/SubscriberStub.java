package dacus.core.subscriber;

import dacus.core.publisher.PublisherStub;
import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.SubscriberMetadata;


public interface SubscriberStub<T extends PartyId> {

	// TODO: think about Object o
	public void update(PublisherStub<T> publisher, Object change);

	public SubscriberMetadata<T> getSubscriberMetadata();

}