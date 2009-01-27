package deus.nsi.xmpp.publisher.impl.stub;

import org.jivesoftware.smack.packet.Presence;

import deus.core.publisher.stub.impl.AbstractPublisherStub;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.model.user.transportid.XmppTransportId;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.publisher.impl.skeleton.XmppPublisherSkeleton;

/**
 * This stub is used to initiate remote communication to a publisher subsystem. It resides on the subscriber system side
 * and is called by the subscriber subsystem. The communication is directed, so there is one stub for each publisher, to
 * which should be talked. Stubs are only used for sending messages, the receiving part is done by other classes
 * (skeletons).
 * 
 * The calls made to this stub are marshaled and sent over XMPP to the publisher. Since this stub lives on the system of
 * the subscriber, a given XMPP conversation to the account of the subscriber is needed. When marshaling a message, a
 * connection is started to this XMPP server. The subscribers' XMPP server then forwards the message to the XMPP server
 * of the publisher, where either a skeleton is listening, or the messages are stored as offline messages.
 * 
 * TODO: think about errors.
 * 
 * An observer can be added to the publisher using the method <code>addObserver(SubscriberMetadata)</code>, or deleted
 * using the corresponding method <code>deleteObserver(SubscriberMetadata)</code>.
 * 
 * Since this stub is used to only talk to one specific publisher, the constructor needs the
 * <code>PublisherMetadata</code> of the publisher, to which the messages should be sent. Furthermore, a started
 * <code>XmppConversation</code> to the XMPP server of the subscriber is needed, to send the marshaled messages.
 * 
 * 
 * @see XmppPublisherSkeleton
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class XmppPublisherStub extends AbstractPublisherStub {

	private final XmppConversation subscriberXmppConversation;


	public XmppPublisherStub(UserId publisherId,
			XmppConversation subscriberXmppConversation) {
		super(publisherId);
		// TODO: think about this assert
		assert (publisherId.hasTransportId(TransportIdType.xmpp));

		this.subscriberXmppConversation = subscriberXmppConversation;
	}


	@Override
	public void addObserver(UserMetadata subscriberMetadata) {
		// TODO: implement this method properly
		// Roster roster = subscriberXmppConversation.getRoster();

		XmppTransportId publisherJid = getPublisherId().getTransportId(XmppTransportId.class);

		// roster.createEntry(publisherJid.toString(), getPublisherMetadata().getFullName(), null);

		Presence presencePacket = new Presence(Presence.Type.subscribe);
		subscriberXmppConversation.sendPacket(presencePacket, publisherJid);
	}


	@Override
	public void deleteObserver(UserMetadata subscriberMetadata) {
		// TODO: implement this method properly
		// Roster roster = subscriberXmppConversation.getRoster();

		XmppTransportId publisherJid = getPublisherId().getTransportId(XmppTransportId.class);

		// roster.removeEntry(roster.getEntry(publisherJid.toString()));

		Presence presencePacket = new Presence(Presence.Type.unsubscribe);
		subscriberXmppConversation.sendPacket(presencePacket, publisherJid);
	}

}
