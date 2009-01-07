package deus.core.subscriber;

import deus.core.publisher.PublisherStub;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;


public interface SubscriberStub<T extends PartyId> {

	// TODO: think about Object o
	public void update(PublisherStub<T> publisher, Object change);

	public SubscriberMetadata<T> getSubscriberMetadata();

}