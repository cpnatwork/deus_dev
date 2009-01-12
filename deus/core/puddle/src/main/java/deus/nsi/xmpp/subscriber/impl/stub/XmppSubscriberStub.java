package deus.nsi.xmpp.subscriber.impl.stub;

import org.jivesoftware.smack.packet.IQ;

import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppAccount;
import deus.nsi.xmpp.common.XmppServer;
import deus.nsi.xmpp.subscriber.impl.FIFChange;

public class XmppSubscriberStub extends AbstractSubscriberStub<XmppUserId> {

	private XmppServer xmppServer;


	public XmppSubscriberStub(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		super(subscriberMetadata);
		assert (subscriberMetadata.getUserId().getType().equals(UserIdType.xmpp));
	}


	@Override
	public void update(PublisherMetadata<XmppUserId> publisher, Object change) {
		// connect to local XMPP account of the subscriber
		// TODO: pass xmppAccount in constructor
		XmppAccount xmppAccount = xmppServer.login(getSubscriberMetadata());

		IQ changeIq = new FIFChange(change);
		xmppAccount.sendPacket(changeIq, publisher.getUserId());
		// TODO: logout again here?
		xmppAccount.logout();
	}


	public void setXmppServer(XmppServer xmppServer) {
		this.xmppServer = xmppServer;
	}

}
