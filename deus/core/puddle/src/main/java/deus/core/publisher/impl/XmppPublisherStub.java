package deus.core.publisher.impl;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

public class XmppPublisherStub<T extends PartyId> extends AbstractPublisherStub<T> {

	public XmppPublisherStub(PublisherMetadata<T> publisherMetadata) {
		super(publisherMetadata);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void addObserver(SubscriberMetadata<T> subscriber) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteObserver(SubscriberMetadata<T> o) {
		// TODO Auto-generated method stub
		
	}


}
