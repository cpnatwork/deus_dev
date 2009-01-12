package deus.nsi.xmpp.publisher.impl.stub;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPException;

import deus.core.publisher.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppAccount;
import deus.nsi.xmpp.common.XmppServer;

public class XmppPublisherStub extends AbstractPublisherStub<XmppUserId> {

	private XmppServer xmppServer;


	public XmppPublisherStub(PublisherMetadata<XmppUserId> publisherMetadata) {
		super(publisherMetadata);
		// TODO: think about this assert
		assert (publisherMetadata.getUserId().getType().equals(UserIdType.xmpp));
	}


	@Override
	public void addObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		// connect to local XMPP account of the subscriber
		// TODO: pass xmppAccount in constructor
		XmppAccount xmppAccount = xmppServer.login(subscriberMetadata);

		Roster roster = xmppAccount.getRoster();

		XmppUserId publisherJid = getPublisherMetadata().getUserId();

		try {
			roster.createEntry(publisherJid.toString(), getPublisherMetadata().getFullName(), null);
		}
		catch (XMPPException e) {
			// TODO: think about exception
			throw new RuntimeException(e);
		}
	}


	@Override
	public void deleteObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		// TODO: pass xmppAccount in constructor
		XmppAccount xmppAccount = xmppServer.login(subscriberMetadata);

		Roster roster = xmppAccount.getRoster();

		XmppUserId publisherJid = getPublisherMetadata().getUserId();

		try {
			roster.removeEntry(roster.getEntry(publisherJid.toString()));
		}
		catch (XMPPException e) {
			// TODO: think about exception
			throw new RuntimeException(e);
		}
	}


	public void setXmppServer(XmppServer xmppServer) {
		this.xmppServer = xmppServer;
	}
}
