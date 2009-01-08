package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class XmppSubscriberStub<Id extends PartyId> extends AbstractSubscriberStub<Id> {

	public XmppSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		super(subscriberMetadata);
	}

	@Override
	public void update(PublisherStub<Id> publisher, Object change) {
		// TODO Auto-generated method stub

	}

}
