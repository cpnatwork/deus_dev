/**
 * 
 */
package deus.nsi.xmpp.common;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.packet.Packet;

import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;


class ExceptionCatchingPacketListener implements PacketListener {
	
	private final FilteredPacketListener filteredPacketListenerDelegate;

	public ExceptionCatchingPacketListener(FilteredPacketListener filteredPacketListener) {
		this.filteredPacketListenerDelegate = filteredPacketListener;
	}

	@Override
	public void processPacket(Packet packet) {
		try {
			filteredPacketListenerDelegate.processPacket(packet);
		}
		catch(Throwable t) {
			// since the smack library eats all exceptions thrown in processPacket(Packet) silently
			// we catch all exceptions here and print them to STDERR
			// TODO: log exception
			t.printStackTrace();
			// TODO: exit here??
			System.exit(0);
		}
	}
	
	
	
}