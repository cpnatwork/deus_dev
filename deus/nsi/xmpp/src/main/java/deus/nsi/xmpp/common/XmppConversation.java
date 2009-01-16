package deus.nsi.xmpp.common;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.packet.Packet;

import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;


public interface XmppConversation {

	public abstract Roster getRoster();


	public abstract void sendPacket(Packet packet, XmppUserId receiver);


	public abstract boolean isLoggedIn();


	public abstract void logout();


	public abstract void addPacketListener(FilteredPacketListener filteredPacketListener);


	public abstract void clearRoster();

}