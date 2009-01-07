package deus.core.subscriber;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

public interface SubscriberStubFactory {

	public <T extends PartyId> SubscriberStub<T> createSubscriberStub(SubscriberMetadata<T> subscriberMetadata,
			PublisherMetadata<T> publisherMetadata);

}
