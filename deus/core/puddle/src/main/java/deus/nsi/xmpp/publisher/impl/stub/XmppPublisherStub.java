package deus.nsi.xmpp.publisher.impl.stub;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPException;

import deus.core.publisher.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppAccount;

public class XmppPublisherStub extends AbstractPublisherStub<XmppUserId> {

	private final XmppAccount subscriberXmppAccount;


	public XmppPublisherStub(PublisherMetadata<XmppUserId> publisherMetadata, XmppAccount subscriberXmppAccount) {
		super(publisherMetadata);
		// TODO: think about this assert
		assert (publisherMetadata.getUserId().getType().equals(UserIdType.xmpp));
		
		this.subscriberXmppAccount = subscriberXmppAccount;
	}


	@Override
	public void addObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		Roster roster = subscriberXmppAccount.getRoster();

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
		Roster roster = subscriberXmppAccount.getRoster();

		XmppUserId publisherJid = getPublisherMetadata().getUserId();

		try {
			roster.removeEntry(roster.getEntry(publisherJid.toString()));
		}
		catch (XMPPException e) {
			// TODO: think about exception
			throw new RuntimeException(e);
		}
	}

}
