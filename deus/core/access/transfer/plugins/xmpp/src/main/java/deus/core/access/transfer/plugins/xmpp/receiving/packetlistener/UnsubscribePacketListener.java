package deus.core.access.transfer.plugins.xmpp.receiving.packetlistener;

import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.plugins.xmpp.receiving.packetlistener.impl.UserMetadataParsingFilteredPacketListener;
import deus.core.access.transfer.plugins.xmpp.util.PacketPrinter;


public class UnsubscribePacketListener extends UserMetadataParsingFilteredPacketListener {

	@Override
	public PacketFilter getFilter() {
		PacketTypeFilter typeFilter = new PacketTypeFilter(Presence.class);
		PacketFilter unsubscribeFilter = new PacketFilter() {

			@Override
			public boolean accept(Packet packet) {
				Presence presence = (Presence) packet;
				return presence.getType().equals(Type.unsubscribe);
			}

		};
		PacketFilter andPacketFilter = new AndFilter(typeFilter, unsubscribeFilter);
		return andPacketFilter;
	}


	@Override
	public void processPacket(Packet packet) {
		// TODO: remove output
		PacketPrinter printer = new PacketPrinter();
		System.out.println("SubscribePacketListener: processing packet:");
		System.out.println(printer.printPacket(packet));

		TransportMessage command = new UnsubscribeMessage();
		receiveCommand(command, packet);
	}


}
