package deus.nsi.xmpp.publisher.impl.stub;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPConnection;

import deus.core.publisher.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.LocalXmppServer;

public class XmppPublisherStub extends AbstractPublisherStub<XmppUserId> {

	private final LocalXmppServer localXmppServer;
	
	public XmppPublisherStub(PublisherMetadata<XmppUserId> publisherMetadata) {
		super(publisherMetadata);
		// TODO: think about this assert
		assert(publisherMetadata.getUserId().getType().equals(UserIdType.xmpp));
		this.localXmppServer = new LocalXmppServer();
	}
	
	@Override
	public void addObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		// connect to local XMPP account of the subscriber
		XMPPConnection localConnection = localXmppServer.login(subscriberMetadata.getUserId());

		Roster roster = localConnection.getRoster();
		
		XmppUserId publisherJid = getPublisherMetadata().getUserId();
		roster.createEntry(publisherJid.toString(), getPublisherMetadata().getFullName(), null);
	}


	@Override
	public void deleteObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		XMPPConnection localConnection = localXmppServer.login(subscriberMetadata.getUserId());

		Roster roster = localConnection.getRoster();
		
		XmppUserId publisherJid = getPublisherMetadata().getUserId();
		roster.removeEntry(roster.getEntry(publisherJid.toString()));
	}


}
