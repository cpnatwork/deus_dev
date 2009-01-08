package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.Subscriber;
import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class LocalSubscriberStub<Id extends PartyId> extends AbstractSubscriberStub<Id>  {

	private Subscriber<Id> subscriber;

	
	public LocalSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		super(subscriberMetadata);
	}
	
	@Override
	public void update(PublisherStub<Id> publisher, Object change) {
		// FIXME: get subscriber using subscriberMetadata
		subscriber.update(publisher, change);
	}


}
