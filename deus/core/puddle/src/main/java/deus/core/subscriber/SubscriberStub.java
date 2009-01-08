package deus.core.subscriber;

import deus.core.publisher.PublisherStub;
import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;


public interface SubscriberStub<Id extends PartyId> {

	// TODO: think about Object o
	public void update(PublisherStub<Id> publisher, Object change);

	public SubscriberMetadata<Id> getSubscriberMetadata();

}