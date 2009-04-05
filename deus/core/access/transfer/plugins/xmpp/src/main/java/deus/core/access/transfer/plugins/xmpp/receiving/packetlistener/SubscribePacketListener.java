package deus.core.access.transfer.plugins.xmpp.receiving.packetlistener;

import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.plugins.xmpp.receiving.packetlistener.impl.UserMetadataParsingFilteredPacketListener;
import deus.core.access.transfer.plugins.xmpp.util.PacketPrinter;
import deus.model.user.UserMetadata;


public class SubscribePacketListener extends UserMetadataParsingFilteredPacketListener {

	
	@Override
	public PacketFilter getFilter() {
		PacketTypeFilter typeFilter = new PacketTypeFilter(Presence.class);
		PacketFilter unsubscribeFilter = new PacketFilter() {

			@Override
			public boolean accept(Packet packet) {
				Presence presence = (Presence) packet;
				return presence.getType().equals(Type.subscribe);
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

		UserMetadata subscriberMetadata = new UserMetadata();
		// FIXME: fill subscriberMetadata
		
		TransportMessage command = new RequestSubscriptionMessage(subscriberMetadata);
		receiveCommand(command, packet);
	}
	
	
	/**
	 * Returns a UserMetadata object which is filled by parsing the package 'from' element and the package property with
	 * the name, that is set by the method <code>setXmppPropertyFullName</code>.
	 * 
	 * @param packet the packet, from which to parse the 'from' data
	 * @return
	 */
//	@Deprecated
//	protected UserMetadata parseFromUserMetadata(Packet packet) {
//		UserMetadata userMetadata = new UserMetadata();
//		// String from = packet.getFrom();
//		// if (from == null)
//		// throw new RuntimeException("'from' field is null at this presence packet: " + packet);
//
//		UserId userId = new UserUrl();
//
//		// FIXME: parse userURL (also think about parsing UserUrl vs. UserXri, ...)
//
//		userMetadata.setUserId(userId);
//
//		Object fullName = packet.getProperty(xmppConfiguration.getXmppPropertyFullName());
//		if (fullName == null)
//			throw new RuntimeException("property '" + xmppConfiguration.getXmppPropertyFullName()
//					+ "' is null at this presence packet: " + packet);
//		userMetadata.setFullName(fullName.toString());
//
//		return userMetadata;
//	}

}
