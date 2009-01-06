package dacus.core.subscriber;

import dacus.core.publisher.PublisherStub;
import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.SubscriberMetadata;


public interface Subscriber<T extends PartyId> {

	// TODO: think about Object change
	public abstract void update(PublisherStub<T> publisher, Object change);


	public abstract SubscriberMetadata<T> getSubscriberMetadata();

}