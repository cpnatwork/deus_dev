package deus.nsi.xmpp.publisher.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smack.util.StringUtils;

import deus.core.publisher.Publisher;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.LocalXmppServer;

public class XmppPublisherSkeleton {

	// TODO: externalize property name
	private final static String XMPP_PROPERTY_FULLNAME = "fullName";

	private final LocalXmppServer localXmppServer;

	private final Publisher<XmppUserId> publisher;


	public XmppPublisherSkeleton(Publisher<XmppUserId> publisher) {
		// TODO: think about this assert
		assert (publisher.getPublisherMetadata().getUserId().getType().equals(UserIdType.xmpp));
		this.publisher = publisher;
		this.localXmppServer = new LocalXmppServer();
	}

	private SubscriberMetadata<XmppUserId> parseSubscriberMetadata(Packet packet) {
		String from = packet.getFrom();
		if (from == null)
			throw new RuntimeException("'from' field is null at this presence packet: " + packet);

		XmppUserId subscriberJid = new XmppUserId();
		subscriberJid.setServer(StringUtils.parseServer(from));
		subscriberJid.setUsername(StringUtils.parseName(from));

		SubscriberMetadata<XmppUserId> subscriberMetadata = new SubscriberMetadata<XmppUserId>();
		subscriberMetadata.setUserId(subscriberJid);

		String fullName = packet.getProperty(XMPP_PROPERTY_FULLNAME).toString();
		if (fullName == null)
			throw new RuntimeException("property '" + XMPP_PROPERTY_FULLNAME
					+ "' is null at this presence packet: " + packet);
		subscriberMetadata.setFullName(fullName);
		
		return subscriberMetadata;
	}
	
	public void connect() {
		// connect to local XMPP account of the publisher
		XMPPConnection localConnection = localXmppServer.login(publisher.getPublisherMetadata().getUserId());

		localConnection.addPacketListener(new PacketListener() {

			@Override
			public void processPacket(Packet packet) {
				Presence presence = (Presence) packet;
				if (presence.getType().equals(Type.subscribe)) {
					SubscriberMetadata<XmppUserId> subscriberMetadata = parseSubscriberMetadata(presence);

					// TODO: add subscribe request to attention list
					publisher.addObserver(subscriberMetadata);
				}
				else if (presence.getType().equals(Type.unsubscribe)) {
					SubscriberMetadata<XmppUserId> subscriberMetadata = parseSubscriberMetadata(presence);

					// TODO: unsubscribe user and put notice to attention list
					publisher.deleteObserver(subscriberMetadata);
				}
			}

		}, new PacketTypeFilter(Presence.class));
	}
}
