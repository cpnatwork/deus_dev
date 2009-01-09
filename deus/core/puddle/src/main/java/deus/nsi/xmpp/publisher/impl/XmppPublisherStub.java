package deus.nsi.xmpp.publisher.impl;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPConnection;

import deus.core.publisher.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;

public class XmppPublisherStub extends AbstractPublisherStub<XmppUserId> {

	public XmppPublisherStub(PublisherMetadata<XmppUserId> publisherMetadata) {
		super(publisherMetadata);
		assert(publisherMetadata.getUserId().getType().equals(UserIdType.xmpp));
	}

	private XMPPConnection connectToSubscriberServer(XmppUserId subscriberJid) {
		XMPPConnection connection = new XMPPConnection(subscriberJid.getServer());
		connection.connect();
		// FIXME: what to do with password?
		connection.login(subscriberJid.getUsername(), "password");
	}
	

	@Override
	public void addObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		XMPPConnection connection = connectToSubscriberServer(subscriberMetadata.getUserId());

		Roster roster = connection.getRoster();
		
		XmppUserId publisherJid = (XmppUserId)getPublisherMetadata().getUserId();
		roster.createEntry(publisherJid.getJidString(), getPublisherMetadata().getFullName(), null);		
	}


	@Override
	public void deleteObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		XMPPConnection connection = connectToSubscriberServer(subscriberMetadata.getUserId());

		Roster roster = connection.getRoster();
		
		XmppUserId publisherJid = (XmppUserId)getPublisherMetadata().getUserId();
		roster.removeEntry(roster.getEntry(publisherJid.getJidString()));
	}


}
