package deus.nsi.xmpp.common.impl;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Packet;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;

public class XmppConversationImpl implements XmppConversation {

	private final XMPPConnection connection;
	private final UserMetadata<XmppUserId> userMetadata;
	private String xmppPropertyFullName;


	public XmppConversationImpl(XMPPConnection connection, UserMetadata<XmppUserId> userMetadata) {
		this.connection = connection;
		this.userMetadata = userMetadata;
	}


	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppConversation#getRoster()
	 */
	public Roster getRoster() {
		if (!connection.isConnected())
			throw new IllegalStateException("Cannot get roster. No connection to account of "
					+ userMetadata.getUserId());
		return connection.getRoster();
	}


	// TODO: think about how to make clear, that TO, FROM and 'fullname' property are set in this method
	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppConversation#sendPacket(org.jivesoftware.smack.packet.Packet, deus.model.user.id.XmppUserId)
	 */
	public void sendPacket(Packet packet, XmppUserId receiver) {
		if (!connection.isConnected())
			throw new IllegalStateException("Cannot send packet. No connection to account of "
					+ userMetadata.getUserId());
		packet.setTo(receiver.toString());
		packet.setFrom(userMetadata.toString());
		packet.setProperty(xmppPropertyFullName, userMetadata.getFullName());
		connection.sendPacket(packet);
	}


	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppConversation#isLoggedIn()
	 */
	public boolean isLoggedIn() {
		return connection.isAuthenticated();
	}


	// TODO: think about logout method, should it be externalized into XmppServer??
	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppConversation#logout()
	 */
	public void logout() {
		connection.disconnect();
	}


	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppConversation#addPacketListener(deus.nsi.xmpp.common.packetfilter.FilteredPacketListener)
	 */
	public void addPacketListener(FilteredPacketListener filteredPacketListener) {
		// wrapping PacketListener and PacketFilter into exception catching ones
		connection.addPacketListener(
				new ExceptionCatchingPacketListener(filteredPacketListener.getPacketListener()),
				new ExceptionCatchingPacketFilter(filteredPacketListener.getFilter()));
	}
	
	
	// TODO: think, if this is a good idea...
	public void setXmppPropertyFullName(String xmppPropertyFullName) {
		this.xmppPropertyFullName = xmppPropertyFullName;
	}


	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppConversation#clearRoster()
	 */
	public void clearRoster() {
		Roster roster = connection.getRoster();
		for(RosterEntry entry : roster.getEntries()) {
			try {
				roster.removeEntry(entry);
			}
			catch (XMPPException e) {
				// TODO: improve exception handling
				throw new RuntimeException(e);
			}
		}
	}

}
