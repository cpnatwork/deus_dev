package deus.nsi.xmpp.subscriber.impl.skeleton.packetlistener;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;
import deus.nsi.xmpp.subscriber.impl.FIFChange;

public class UpdatePacketListener extends SubscriberPacketListener {

	@Override
	public PacketFilter getFilter() {
		return new PacketTypeFilter(FIFChange.class);
	}


	@Override
	protected void processPacket(Packet packet) {
		IQ iq = (IQ) packet;
		// TODO: do checks
		FIFChange fifChange = (FIFChange) iq;
		String xml = fifChange.getChildElementXML();

		ForeignInformationFile change = null;
		// TODO: do XML to object binding
		// change = xmltoobjectbind(xml);

		PublisherMetadata publisherMetadata = new PublisherMetadata();
		parseFromUserMetadata(packet, publisherMetadata);

		subscriber.update(publisherMetadata, change);
	}

}
