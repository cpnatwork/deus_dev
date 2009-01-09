package deus.nsi.xmpp.publisher.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;

import deus.core.publisher.Publisher;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;

public class XmppPublisherSkeleton {

	private final Publisher<XmppUserId> publisher;


	public XmppPublisherSkeleton(Publisher<XmppUserId> publisher) {
		assert (publisher.getPublisherMetadata().getUserId().getType().equals(UserIdType.xmpp));
		this.publisher = publisher;
	}


	public void connect() {
		XmppUserId publisherJid = publisher.getPublisherMetadata().getUserId();

		XMPPConnection connection = new XMPPConnection(publisherJid.getServer());
		connection.connect();
		// FIXME: what to do with password??
		connection.login(publisherJid.getUsername(), "password");
		
		connection.addPacketListener(new PacketListener() {

			@Override
			public void processPacket(Packet packet) {
				Presence presence = (Presence)packet;
				if(presence.getType().equals(Type.subscribe)) {
					// TODO: add subscribe request to attention list					
				}
				else if(presence.getType().equals(Type.unsubscribe)) {
					// TODO: unsubscribe user and put notice to attention list
				}
			}
			
		}, new PacketTypeFilter(Presence.class));
	}

}
