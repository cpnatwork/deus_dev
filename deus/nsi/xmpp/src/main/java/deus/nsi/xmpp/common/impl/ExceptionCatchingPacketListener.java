/**
 * 
 */
package deus.nsi.xmpp.common.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.packet.Packet;


class ExceptionCatchingPacketListener implements PacketListener {
	
	private final PacketListener packetListenerDelegate;

	public ExceptionCatchingPacketListener(PacketListener packetListener) {
		this.packetListenerDelegate = packetListener;
	}

	@Override
	public void processPacket(Packet packet) {
		try {
			// delegate to packetListenerDelegate
			packetListenerDelegate.processPacket(packet);
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