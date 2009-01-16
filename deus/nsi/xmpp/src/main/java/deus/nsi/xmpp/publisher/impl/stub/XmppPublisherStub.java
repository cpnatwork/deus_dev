package deus.nsi.xmpp.publisher.impl.stub;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

import deus.core.publisher.impl.AbstractPublisherStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppConversation;

public class XmppPublisherStub extends AbstractPublisherStub<XmppUserId> {

	private final XmppConversation subscriberXmppConversation;


	public XmppPublisherStub(PublisherMetadata<XmppUserId> publisherMetadata, XmppConversation subscriberXmppConversation) {
		super(publisherMetadata);
		// TODO: think about this assert
		assert (publisherMetadata.getUserId().getType().equals(UserIdType.xmpp));
		
		this.subscriberXmppConversation = subscriberXmppConversation;
	}


	@Override
	public void addObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		// TODO: implement this method properly
		//Roster roster = subscriberXmppConversation.getRoster();

		XmppUserId publisherJid = getPublisherMetadata().getUserId();

		//roster.createEntry(publisherJid.toString(), getPublisherMetadata().getFullName(), null);
		
        Presence presencePacket = new Presence(Presence.Type.subscribe);
        subscriberXmppConversation.sendPacket(presencePacket, publisherJid);
	}


	@Override
	public void deleteObserver(SubscriberMetadata<XmppUserId> subscriberMetadata) {
		// TODO: implement this method properly
		//Roster roster = subscriberXmppConversation.getRoster();

		XmppUserId publisherJid = getPublisherMetadata().getUserId();

		//roster.removeEntry(roster.getEntry(publisherJid.toString()));
		
		Presence presencePacket = new Presence(Presence.Type.unsubscribe);
        subscriberXmppConversation.sendPacket(presencePacket, publisherJid);
	}

}
