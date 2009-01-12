package deus.nsi.xmpp.subscriber.impl.stub;

import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.LocalXmppServer;

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
public class XmppSubscriberStubFactory implements SubscriberStubFactory<XmppUserId> {

	private LocalXmppServer localXmppServer;
	
	@Override
	public boolean canHandle(UserIdType userIdType) {
		return userIdType.equals(UserIdType.xmpp);
	}


	@Override
	public SubscriberStub<XmppUserId> createSubscriberStub(SubscriberMetadata<XmppUserId> subscriberMetadata,
			PublisherMetadata<XmppUserId> publisherMetadata) {
		return new XmppSubscriberStub(subscriberMetadata);
	}

	/**
	 * Sets the LocalXmppServer class for injecting it into XmppSubscriberStub when it is created.
	 * @param localXmppServer	the instance of localXmppServer
	 */
	public void setLocalXmppServer(LocalXmppServer localXmppServer) {
		this.localXmppServer = localXmppServer;
	}
	
}
