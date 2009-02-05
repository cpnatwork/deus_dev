package deus.transport.xmpp.common.impl;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

class ExceptionCatchingPacketFilter implements PacketFilter {

	private final PacketFilter packetFilterDelegate;
	
	public ExceptionCatchingPacketFilter(PacketFilter filter) {
		this.packetFilterDelegate = filter;
	}

	@Override
	public boolean accept(Packet packet) {
		try {
			// delegate to packetFilterDelegate
			return packetFilterDelegate.accept(packet);
		}
		catch(Throwable t) {
			// since the smack library eats all exceptions thrown in processPacket(Packet) silently
			// we catch all exceptions here and print them to STDERR
			// TODO: log exception
			t.printStackTrace();
			// TODO: exit here??
			System.exit(0);
			// not caught by SMACK library
			throw new RuntimeException(t);
		}
	}

}
