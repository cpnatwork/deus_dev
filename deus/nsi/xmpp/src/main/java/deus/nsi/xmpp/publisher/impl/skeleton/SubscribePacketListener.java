package deus.nsi.xmpp.publisher.impl.skeleton;

import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;
import org.springframework.stereotype.Component;

import deus.core.publisher.RemoteCalledPublisher;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.util.PacketPrinter;


public class SubscribePacketListener extends PublisherPacketListener {

	public SubscribePacketListener(RemoteCalledPublisher<XmppUserId> publisher) {
		super(publisher);
	}


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
		PacketPrinter printer = new PacketPrinter();
		System.out.println("SubscribePacketListener: processing packet:");
		System.out.println(printer.printPacket(packet));

		Presence presence = (Presence) packet;

		SubscriberMetadata<XmppUserId> subscriberMetadata = new SubscriberMetadata<XmppUserId>();
		parseFromUserMetadata(presence, subscriberMetadata);

		// TODO: add subscribe request to attention list
		publisher.addObserver(subscriberMetadata);
		// TODO: send an answer back after adding
	}

}
