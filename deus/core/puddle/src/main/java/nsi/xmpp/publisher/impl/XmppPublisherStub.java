package nsi.xmpp.publisher.impl;

import deus.core.publisher.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;

public class XmppPublisherStub<Id extends UserId> extends AbstractPublisherStub<Id> {

	public XmppPublisherStub(PublisherMetadata<Id> publisherMetadata) {
		super(publisherMetadata);
		assert(publisherMetadata.getUserId().getType().equals(UserIdType.xmpp));
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
