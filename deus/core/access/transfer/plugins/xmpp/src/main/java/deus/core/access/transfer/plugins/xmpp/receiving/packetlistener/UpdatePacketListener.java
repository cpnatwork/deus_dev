package deus.core.access.transfer.plugins.xmpp.receiving.packetlistener;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.core.messages.publication.UpdateMessage;
import deus.core.access.transfer.plugins.xmpp.PatchPacket;
import deus.core.access.transfer.plugins.xmpp.receiving.packetlistener.impl.UserMetadataParsingFilteredPacketListener;
import deus.core.access.transfer.plugins.xmpp.util.PacketPrinter;
import deus.model.dossier.DigitalCard;

public class UpdatePacketListener extends UserMetadataParsingFilteredPacketListener {

	@Override
	public PacketFilter getFilter() {
		return new PacketTypeFilter(PatchPacket.class);
	}


	@Override
	protected void processPacket(Packet packet) {
		// TODO: remove output
		PacketPrinter printer = new PacketPrinter();
		System.out.println("SubscribePacketListener: processing packet:");
		System.out.println(printer.printPacket(packet));

		
		IQ iq = (IQ) packet;
		// TODO: do checks
		PatchPacket fifChange = (PatchPacket) iq;
		String xml = fifChange.getChildElementXML();

		DigitalCard digitalCard = null;
		// TODO: do XML to object binding
		// digitalCard = xmltoobjectbind(xml);

		TransferMessage command = new UpdateMessage(digitalCard);
		receiveCommand(command, packet);
	}

}
