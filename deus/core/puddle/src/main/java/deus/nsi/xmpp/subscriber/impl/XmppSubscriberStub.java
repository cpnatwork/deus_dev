package deus.nsi.xmpp.subscriber.impl;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.impl.AbstractSubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;

public class XmppSubscriberStub<Id extends UserId> extends AbstractSubscriberStub<Id> {

	public XmppSubscriberStub(SubscriberMetadata<Id> subscriberMetadata) {
		super(subscriberMetadata);
		assert(subscriberMetadata.getUserId().getType().equals(UserIdType.xmpp));
	}


	@Override
	public void update(PublisherStub<Id> publisher, Object change) {
		XmppUserId publisherJid = (XmppUserId)publisher.getPublisherMetadata().getUserId();
		XmppUserId subscriberJid = (XmppUserId)subscriberMetadata.getUserId();
		
		XMPPConnection connection = new XMPPConnection(publisherJid.getServer());
		connection.connect();
		// FIXME: what to do with password?
		connection.login(publisherJid.getUsername(), "password");
		
		IQ changeIq = new FIFChange(change);
		
		connection.sendPacket(changeIq);
	}

}
