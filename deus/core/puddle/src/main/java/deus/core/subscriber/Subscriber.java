package deus.core.subscriber;

import deus.core.publisher.PublisherStub;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;


public interface Subscriber<T extends PartyId> {

	// TODO: think about Object change
	public abstract void update(PublisherStub<T> publisher, Object change);


	public abstract SubscriberMetadata<T> getSubscriberMetadata();

}