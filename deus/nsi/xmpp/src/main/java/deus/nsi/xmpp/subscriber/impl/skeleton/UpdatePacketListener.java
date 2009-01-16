package deus.nsi.xmpp.subscriber.impl.skeleton;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.core.subscriber.RemoteCalledSubscriber;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.subscriber.impl.FIFChange;

public class UpdatePacketListener<DifContentType> extends SubscriberPacketListener<DifContentType> {

	public UpdatePacketListener(RemoteCalledSubscriber<XmppUserId> subscriber) {
		super(subscriber);
	}


	@Override
	public PacketFilter getFilter() {
		return new PacketTypeFilter(IQ.class);
	}


	@Override
	protected void processPacket(Packet packet) {
		IQ iq = (IQ) packet;
		// TODO: do checks
		FIFChange fifChange = (FIFChange) iq;
		String xml = fifChange.getChildElementXML();

		Object change = null;
		// TODO: do XML to object binding
		// change = xmltoobjectbind(xml);

		PublisherMetadata<XmppUserId> publisherMetadata = new PublisherMetadata<XmppUserId>();
		parseFromUserMetadata(packet, publisherMetadata);

		subscriber.update(publisherMetadata, change);
	}

}
