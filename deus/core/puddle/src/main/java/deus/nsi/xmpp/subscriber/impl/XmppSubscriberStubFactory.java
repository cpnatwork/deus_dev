package deus.nsi.xmpp.subscriber.impl;

import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;

/**
 * <code>SubscriberStubFactory</code> which creates
 * <code>LocalSubscriberStubs</code>. It can be used as subfactory in 
 * <code>/deus-core-puddle/src/main/java/deus/core/subscriber/impl/DelegateSubscriberStubFactory</code>
 * for creating <code>SubscriberStubs</code> for user id type
 * <code>UserIdType.local</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class XmppSubscriberStubFactory implements SubscriberStubFactory {

	@Override
	public boolean canHandle(UserIdType userIdType) {
		return userIdType.equals(UserIdType.xmpp);
	}


	@Override
	public <Id extends UserId> SubscriberStub<Id> createSubscriberStub(SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata) {
		return new XmppSubscriberStub<Id>(subscriberMetadata);
	}

}
