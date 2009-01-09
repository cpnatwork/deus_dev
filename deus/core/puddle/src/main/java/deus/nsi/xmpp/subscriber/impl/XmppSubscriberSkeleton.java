package deus.nsi.xmpp.subscriber.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.core.subscriber.Subscriber;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;

public class XmppSubscriberSkeleton {

	private final Subscriber<XmppUserId> subscriber;


	public XmppSubscriberSkeleton(Subscriber<XmppUserId> subscriber) {
		assert (subscriber.getSubscriberMetadata().getUserId().getType().equals(UserIdType.xmpp));
		this.subscriber = subscriber;
	}


	public void connect() {
		XmppUserId subscriberJid = subscriber.getSubscriberMetadata().getUserId();

		XMPPConnection connection = new XMPPConnection(subscriberJid.getServer());
		connection.connect();
		// FIXME: what to do with password??
		connection.login(subscriberJid.getUsername(), "password");

		connection.addPacketListener(new PacketListener() {

			@Override
			public void processPacket(Packet packet) {
				IQ iq = (IQ)packet;
				// TODO: do checks
				FIFChange fifChange = (FIFChange)iq;
				String xml = fifChange.getChildElementXML();
				// TODO: do XML to object binding
				//Object change = xmltoobjectbind(xml);
				
			}
			
		}, new PacketTypeFilter(IQ.class));
	}
	
}
