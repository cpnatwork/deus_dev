package deus.core.subscriber.impl;

import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

public class IntelligentSubscriberStubFactory implements SubscriberStubFactory {

	@Override
	public <T extends PartyId> SubscriberStub<T> createSubscriberStub(
			SubscriberMetadata<T> subscriberMetadata,
			PublisherMetadata<T> publisherMetadata) {
		// TODO compare server of subscriber metadata and server of publisher metadata and return either a
		// subscriber stub, which does remoting or a LocalSubscriberStub
		//return new LocalSubscriberStub<T>();
		return null;
	}

}
