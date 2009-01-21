package deus.nsi.xmpp.common.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.model.user.UserMetadata;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.XmppConfiguration;
import deus.nsi.xmpp.common.XmppConversation;

// TODO: think about synchonrization issues (e.g. with adding/removing of packet listeners)
@Configurable
public class XmppConversationImpl implements XmppConversation {

	private final XMPPConnection connection;
	private final UserMetadata<XmppUserId> userMetadata;
	private final String password;
	
	@Autowired
	private XmppConfiguration xmppConfiguration;

	private PacketListenerManager packetListenerManager;


	public XmppConversationImpl(XMPPConnection connection, UserMetadata<XmppUserId> userMetadata, String password) {
		this.connection = connection;
		this.userMetadata = userMetadata;
		this.password = password;
		
		this.packetListenerManager = new PacketListenerManager(connection);
	}


	public void start() {
		try {
			connection.connect();
		}
		catch (XMPPException e) {
			// if the subscriber XMPP server is not available, something fatal went wrong!
			throw new RuntimeException("the local XMPP server of the user " + userMetadata + " is not available", e);
		}

		try {
			connection.login(userMetadata.getUserId().getUsername(), password);
		}
		catch (XMPPException e) {
			// if the the user cannot be logged in his local XMPP server, something fatal went wrong!
			throw new RuntimeException("the XMPP user " + userMetadata + " cannot be logged in his local XMPP server",
					e);
		}
	}


	@Override
	public boolean isStarted() {
		return connection.isAuthenticated();
	}


	private void assertIsStarted() throws IllegalStateException {
		if(!isStarted())
			throw new IllegalStateException("Conversation with XMPP account " + userMetadata.getUserId() + " is not started!");
	}


	// TODO: think about logout method, should it be externalized into XmppServer??
	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.nsi.xmpp.common.XmppConversation#logout()
	 */
	@Override
	public void end() {
		connection.disconnect();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.nsi.xmpp.common.XmppConversation#getRoster()
	 */
	@Override
	public Roster getRoster() {
		assertIsStarted();
		
		return connection.getRoster();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.nsi.xmpp.common.XmppConversation#clearRoster()
	 */
	@Override
	public void clearRoster() {
		assertIsStarted();
		
		Roster roster = getRoster();
		for (RosterEntry entry : roster.getEntries()) {
			try {
				roster.removeEntry(entry);
			}
			catch (XMPPException e) {
				// TODO: improve exception handling
				throw new RuntimeException(e);
			}
		}
	}


	// TODO: think about how to make clear, that TO, FROM and 'fullname' property are set in this method
	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.nsi.xmpp.common.XmppConversation#sendPacket(org.jivesoftware.smack.packet.Packet,
	 * deus.model.user.id.XmppUserId)
	 */
	@Override
	public void sendPacket(Packet packet, XmppUserId receiver) {
		assertIsStarted();
		
		packet.setTo(receiver.toString());
		packet.setFrom(userMetadata.toString());
		packet.setProperty(xmppConfiguration.getXmppPropertyFullName(), userMetadata.getFullName());
		connection.sendPacket(packet);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.nsi.xmpp.common.XmppConversation#addPacketListener(deus.nsi.xmpp.common.packetfilter.FilteredPacketListener)
	 */
	@Override
	public void addPacketListener(PacketListener packetListener, PacketFilter packetFilter) {
		assertIsStarted();
		
		packetListenerManager.addPacketListener(packetListener, packetFilter);
	}


	@Override
	public void removePacketListener(PacketListener packetListener) {
		assertIsStarted();
		
		packetListenerManager.removePacketListener(packetListener);
	}

}
