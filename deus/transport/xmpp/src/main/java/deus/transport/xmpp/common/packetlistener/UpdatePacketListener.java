package deus.transport.xmpp.common.packetlistener;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;

import deus.core.transport.command.Command;
import deus.core.transport.command.UpdateCommand;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.transport.xmpp.FIFChange;
import deus.transport.xmpp.common.packetlistener.impl.UserMetadataParsingFilteredPacketListener;
import deus.transport.xmpp.util.PacketPrinter;

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

		ForeignInformationFile change = null;
		// TODO: do XML to object binding
		// change = xmltoobjectbind(xml);

		Command command = new UpdateCommand(change);
		sendCommand(command, packet);
	}

}
