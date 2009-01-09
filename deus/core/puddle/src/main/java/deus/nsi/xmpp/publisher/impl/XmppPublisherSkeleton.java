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
import deus.nsi.xmpp.common.LocalXmppServer;

public class XmppPublisherSkeleton {

	private final LocalXmppServer localXmppServer;
	
	private final Publisher<XmppUserId> publisher;

	public XmppPublisherSkeleton(Publisher<XmppUserId> publisher) {
		// TODO: think about this assert
		assert (publisher.getPublisherMetadata().getUserId().getType().equals(UserIdType.xmpp));
		this.publisher = publisher;
		this.localXmppServer = new LocalXmppServer();
	}

	public void connect() {
		// connect to local XMPP account of the publisher
		XMPPConnection localConnection = localXmppServer.login(publisher.getPublisherMetadata().getUserId());
		
		localConnection.addPacketListener(new PacketListener() {

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
