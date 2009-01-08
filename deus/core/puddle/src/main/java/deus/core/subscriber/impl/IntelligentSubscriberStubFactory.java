package deus.core.subscriber.impl;

import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class IntelligentSubscriberStubFactory implements SubscriberStubFactory {

	@Override
	public <Id extends UserId> SubscriberStub<Id> createSubscriberStub(
			SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata) {
		// TODO compare server of subscriber metadata and server of publisher metadata and return either a
		// subscriber stub, which does remoting or a LocalSubscriberStub
		//return new LocalSubscriberStub<Id>();
		// also check for type of Id!
		return null;
	}

}
