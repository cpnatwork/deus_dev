package deus.nsi.xmpp.common.packetfilter;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.filter.PacketFilter;

public interface FilteredPacketListener extends PacketListener {

	public PacketFilter getFilter();
	
}
