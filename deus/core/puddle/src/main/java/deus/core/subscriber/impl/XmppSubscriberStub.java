package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class XmppSubscriberStub<T extends PartyId> extends AbstractSubscriberStub<T> {

	public XmppSubscriberStub(SubscriberMetadata<T> subscriberMetadata) {
		super(subscriberMetadata);
	}

	@Override
	public void update(PublisherStub<T> publisher, Object change) {
		// TODO Auto-generated method stub

	}

}
