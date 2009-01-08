package deus.core.subscriber;

import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

public interface SubscriberStubFactory {

	public <Id extends PartyId> SubscriberStub<Id> createSubscriberStub(SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata);

}
