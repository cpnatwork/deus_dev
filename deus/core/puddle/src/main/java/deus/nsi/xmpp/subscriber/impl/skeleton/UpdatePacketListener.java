package deus.nsi.xmpp.subscriber.impl.skeleton;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.core.subscriber.Subscriber;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.subscriber.impl.FIFChange;

public class UpdatePacketListener extends SubscriberPacketListener {

	public UpdatePacketListener(Subscriber<XmppUserId> subscriber) {
		super(subscriber);
	}

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

	@Override
	public PacketFilter getFilter() {
		return new PacketTypeFilter(IQ.class);
	}
	
}
