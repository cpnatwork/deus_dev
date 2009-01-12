package deus.nsi.xmpp.subscriber.impl.stub;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;

import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.LocalXmppServer;
import deus.nsi.xmpp.subscriber.impl.FIFChange;

public class XmppSubscriberStub extends AbstractSubscriberStub<XmppUserId> {

	private String xmppPropertyFullName;
	
	private final LocalXmppServer localXmppServer;

	public XmppSubscriberStub(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		super(subscriberMetadata);
		assert(subscriberMetadata.getUserId().getType().equals(UserIdType.xmpp));
		// TODO: inject this
		this.localXmppServer = new LocalXmppServer();
	}


	@Override
	public void update(PublisherMetadata<XmppUserId> publisher, Object change) {
		// connect to local XMPP account of the subscriber
		XMPPConnection localConnection = localXmppServer.login(subscriberMetadata.getUserId());
		
		IQ changeIq = new FIFChange(change);
		changeIq.setProperty(xmppPropertyFullName, publisher.getFullName());
		localConnection.sendPacket(changeIq);
	}


	public void setXmppPropertyFullName(String xmppPropertyFullName) {
		this.xmppPropertyFullName = xmppPropertyFullName;
	}
	
}
