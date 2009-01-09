package deus.nsi.xmpp.subscriber.impl;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;

import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.LocalXmppServer;

public class XmppSubscriberStub extends AbstractSubscriberStub<XmppUserId> {
	
	private final LocalXmppServer localXmppServer;

	public XmppSubscriberStub(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		super(subscriberMetadata);
		assert(subscriberMetadata.getUserId().getType().equals(UserIdType.xmpp));
		this.localXmppServer = new LocalXmppServer();
	}


	@Override
	public void update(PublisherMetadata<XmppUserId> publisher, Object change) {
		// connect to local XMPP account of the subscriber
		XMPPConnection localConnection = localXmppServer.login(subscriberMetadata.getUserId());
		
		IQ changeIq = new FIFChange(change);
		
		localConnection.sendPacket(changeIq);
	}

}
