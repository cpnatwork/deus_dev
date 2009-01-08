package deus.core.subscriber.impl;

import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

// TODO: where to put this class? it needs knowledge of LocalSubscriberStub, XmppSubscriberStub, ...
public class IntelligentSubscriberStubFactory implements SubscriberStubFactory {

	@Override
	public <Id extends UserId> SubscriberStub<Id> createSubscriberStub(
			SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata) {
		// TODO: decide based on the type of the given subscriberId which subscriber stub to return.
		// TODO: think about this: if there is a possibility to detect, that according to subscriberMetadata
		// and publisherMetadata, both accounts are on the same server, then return a SubscriberStub, which handles all
		// kinds of userIds, but only if their corresponding accounts are on the same server!		
		
		// TODO compare server of subscriber metadata and server of publisher metadata and return either a
		// subscriber stub, which does remoting or a LocalSubscriberStub
		//return new LocalSubscriberStub<Id>();
		// also check for type of Id!
		
		// TODO: think about a chain of responsibility like pattern, so that other packages can add subfactories which are
		// responsibly for several enum values of UserPartyId
		return null;
	}

}
