package deus.nsi.xmpp.subscriber.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.core.subscriber.Subscriber;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.LocalXmppServer;

public class XmppSubscriberSkeleton {

	private final LocalXmppServer localXmppServer;
	
	
	private final Subscriber<XmppUserId> subscriber;


	public XmppSubscriberSkeleton(Subscriber<XmppUserId> subscriber) {
		assert (subscriber.getSubscriberMetadata().getUserId().getType().equals(UserIdType.xmpp));
		this.subscriber = subscriber;
		this.localXmppServer = new LocalXmppServer();
	}


	public void connect() {
		// connect to local XMPP account of the subscriber
		XMPPConnection localConnection = localXmppServer.login(subscriber.getSubscriberMetadata().getUserId());

		localConnection.addPacketListener(new PacketListener() {

			@Override
			public void processPacket(Packet packet) {
				IQ iq = (IQ)packet;
				// TODO: do checks
				FIFChange fifChange = (FIFChange)iq;
				String xml = fifChange.getChildElementXML();
				
				Object change = null;
				// TODO: do XML to object binding
				// change = xmltoobjectbind(xml);
				
				PublisherMetadata<XmppUserId> publisherMetadata = null;
				// TODO: extract PublisherMetadata
				
				subscriber.update(publisherMetadata, change);
			}
			
		}, new PacketTypeFilter(IQ.class));
	}
	
}
