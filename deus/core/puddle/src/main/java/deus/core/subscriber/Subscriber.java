package deus.core.subscriber;

import deus.core.publisher.PublisherStub;
import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;


public interface Subscriber<Id extends PartyId> {

	// TODO: think about Object change
	public abstract void update(PublisherStub<Id> publisher, Object change);


	public abstract SubscriberMetadata<Id> getSubscriberMetadata();

}