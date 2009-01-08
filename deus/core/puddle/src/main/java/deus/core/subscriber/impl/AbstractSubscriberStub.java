package deus.core.subscriber.impl;


import deus.core.subscriber.SubscriberStub;
import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public abstract class AbstractSubscriberStub<Id extends PartyId> implements SubscriberStub<Id> {

	protected final SubscriberMetadata<Id> subscriberMetadata;


	public AbstractSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public SubscriberMetadata<Id> getSubscriberMetadata() {
		return subscriberMetadata;
	}

}