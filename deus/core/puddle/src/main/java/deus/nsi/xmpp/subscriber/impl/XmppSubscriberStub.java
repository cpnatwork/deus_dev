package deus.nsi.xmpp.subscriber.impl;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;

public class XmppSubscriberStub<Id extends UserId> extends AbstractSubscriberStub<Id> {

	public XmppSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		super(subscriberMetadata);
		assert(subscriberMetadata.getUserId().getType().equals(UserIdType.xmpp));
	}


	@Override
	public void update(PublisherStub<Id> publisher, Object change) {
		// FIXME: implement update via XMPP
	}

}
