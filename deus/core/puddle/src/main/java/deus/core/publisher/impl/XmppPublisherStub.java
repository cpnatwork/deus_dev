package deus.core.publisher.impl;

import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

public class XmppPublisherStub<Id extends PartyId> extends AbstractPublisherStub<Id> {

	public XmppPublisherStub(PublisherMetadata<Id> publisherMetadata) {
		super(publisherMetadata);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void addObserver(SubscriberMetadata<Id> subscriber) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteObserver(SubscriberMetadata<Id> o) {
		// TODO Auto-generated method stub
		
	}


}
