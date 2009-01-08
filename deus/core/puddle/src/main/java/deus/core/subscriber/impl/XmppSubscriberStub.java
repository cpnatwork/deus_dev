package deus.core.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public class XmppSubscriberStub<Id extends UserId> extends AbstractSubscriberStub<Id> {

	public XmppSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		super(subscriberMetadata);
	}

	@Override
	public void update(PublisherStub<Id> publisher, Object change) {
		// TODO Auto-generated method stub

	}

}
