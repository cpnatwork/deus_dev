package deus.core.access.transport.plugins.xmpp.receiving.packetlistener;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.UpdateMessage;
import deus.core.access.transport.plugins.xmpp.FIFChange;
import deus.core.access.transport.plugins.xmpp.receiving.packetlistener.impl.UserMetadataParsingFilteredPacketListener;
import deus.core.access.transport.plugins.xmpp.util.PacketPrinter;
import deus.model.dossier.DigitalCard;

public class UpdatePacketListener extends UserMetadataParsingFilteredPacketListener {

	@Override
	public PacketFilter getFilter() {
		return new PacketTypeFilter(FIFChange.class);
	}


	@Override
	protected void processPacket(Packet packet) {
		// TODO: remove output
		PacketPrinter printer = new PacketPrinter();
		System.out.println("SubscribePacketListener: processing packet:");
		System.out.println(printer.printPacket(packet));

		
		IQ iq = (IQ) packet;
		// TODO: do checks
		FIFChange fifChange = (FIFChange) iq;
		String xml = fifChange.getChildElementXML();

		DigitalCard digitalCard = null;
		// TODO: do XML to object binding
		// digitalCard = xmltoobjectbind(xml);

		TransportMessage command = new UpdateMessage(digitalCard);
		sendCommand(command, packet);
	}

}
