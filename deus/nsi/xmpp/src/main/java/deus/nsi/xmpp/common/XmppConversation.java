package deus.nsi.xmpp.common;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

import deus.model.user.id.transportid.XmppTransportId;


public interface XmppConversation {

	public abstract void start();


	public abstract boolean isStarted();


	public abstract void end();


	public abstract Roster getRoster();


	public abstract void clearRoster();


	public abstract void sendPacket(Packet packet, XmppTransportId receiver);


	public abstract void addPacketListener(PacketListener packetListener, PacketFilter packetFilter);


	public abstract void removePacketListener(PacketListener packetListener);

}