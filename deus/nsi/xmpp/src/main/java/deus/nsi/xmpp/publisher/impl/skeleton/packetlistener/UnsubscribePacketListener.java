package deus.nsi.xmpp.publisher.impl.skeleton.packetlistener;

import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;

import deus.core.publisher.RemoteCalledPublisher;
import deus.model.pub.SubscriberMetadata;
import deus.nsi.xmpp.util.PacketPrinter;


public class UnsubscribePacketListener extends PublisherPacketListener {

	public UnsubscribePacketListener(RemoteCalledPublisher publisher) {
		super(publisher);
	}


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
		PacketPrinter printer = new PacketPrinter();
		System.out.println("UnsubscribePacketListener: processing packet:");
		System.out.println(printer.printPacket(packet));

		Presence presence = (Presence) packet;
		SubscriberMetadata subscriberMetadata = new SubscriberMetadata();
		parseFromUserMetadata(presence, subscriberMetadata);

		// TODO: unsubscribe user and put notice to attention list
		publisher.deleteObserver(subscriberMetadata);
	}


}
