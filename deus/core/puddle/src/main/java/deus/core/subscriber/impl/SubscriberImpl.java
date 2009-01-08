package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.Subscriber;
import deus.core.subscriber.SubscriberStub;
import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class SubscriberImpl<Id extends PartyId> implements SubscriberStub<Id>, Subscriber<Id> {

	private final SubscriberMetadata<Id> subscriberMetadata;


	public SubscriberImpl(SubscriberMetadata<Id> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public void update(PublisherStub<Id> publisher, Object change) {
		// FIXME: how to do object change
	}


	@Override
	public SubscriberMetadata<Id> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}
