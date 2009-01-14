package deus.nsi.xmpp.common;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Packet;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;

public class XmppAccount {

	private final XMPPConnection connection;
	private final UserMetadata<XmppUserId> userMetadata;
	private String xmppPropertyFullName;


	public XmppAccount(XMPPConnection connection, UserMetadata<XmppUserId> userMetadata) {
		this.connection = connection;
		this.userMetadata = userMetadata;
	}


	public Roster getRoster() {
		if (!connection.isConnected())
			throw new IllegalStateException("Cannot get roster. No connection to account of "
					+ userMetadata.getUserId());
		return connection.getRoster();
	}


	// TODO: think about how to make clear, that TO, FROM and 'fullname' property are set in this method
	public void sendPacket(Packet packet, XmppUserId receiver) {
		if (!connection.isConnected())
			throw new IllegalStateException("Cannot send packet. No connection to account of "
					+ userMetadata.getUserId());
		packet.setTo(receiver.toString());
		packet.setFrom(userMetadata.toString());
		packet.setProperty(xmppPropertyFullName, userMetadata.getFullName());
		connection.sendPacket(packet);
	}


	public boolean isLoggedIn() {
		return connection.isAuthenticated();
	}


	// TODO: think about logout method, should it be externalized into XmppServer??
	public void logout() {
		connection.disconnect();
	}


	public void addPacketListener(FilteredPacketListener filteredPacketListener) {
		// wrapping PacketListener and PacketFilter into exception catching ones
		connection.addPacketListener(
				new ExceptionCatchingPacketListener(filteredPacketListener),
				new ExceptionCatchingPacketFilter(filteredPacketListener.getFilter()));
	}
	
	
	// TODO: think, if this is a good idea...
	public void setXmppPropertyFullName(String xmppPropertyFullName) {
		this.xmppPropertyFullName = xmppPropertyFullName;
	}

}
