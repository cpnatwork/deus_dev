package deus.core.access.transfer.plugins.xmpp.common;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransportId;


public interface XmppConversation {

	public abstract void connect();


	public abstract boolean isConnected();


	public abstract void login();


	public abstract boolean isLoggedIn();


	public abstract void end();


	public abstract Roster getRoster();


	public abstract void clearRoster();


	public abstract void sendPacket(Packet packet, XmppTransportId receiver);


	public abstract void addPacketListener(PacketListener packetListener, PacketFilter packetFilter);


	public abstract void addFilteredPacketListener(FilteredPacketListener filteredPacketListener);


	public abstract void removePacketListener(PacketListener packetListener);


	public abstract void removeAllPacketListeneres();
}