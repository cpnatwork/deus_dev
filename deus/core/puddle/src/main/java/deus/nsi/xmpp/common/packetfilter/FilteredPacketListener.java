package deus.nsi.xmpp.common.packetfilter;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

public interface FilteredPacketListener {

	public PacketFilter getFilter();
	
    public void processPacket(Packet packet);
	
}
