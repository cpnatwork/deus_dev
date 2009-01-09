package deus.nsi.xmpp.subscriber.impl;

import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.subscriber.impl.stub.XmppSubscriberStub;

public class XmppSubscriberStubFactory implements SubscriberStubFactory<XmppUserId> {

	@Override
	public boolean canHandle(UserIdType userIdType) {
		return userIdType.equals(UserIdType.xmpp);
	}

	@Override
	public SubscriberStub<XmppUserId> createSubscriberStub(SubscriberMetadata<XmppUserId> subscriberMetadata,
			PublisherMetadata<XmppUserId> publisherMetadata) {
		return new XmppSubscriberStub(subscriberMetadata);
	}

}
