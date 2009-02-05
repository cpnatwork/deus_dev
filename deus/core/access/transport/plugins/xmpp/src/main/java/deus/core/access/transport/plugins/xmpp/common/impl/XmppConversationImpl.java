package deus.core.access.transport.plugins.xmpp.common.impl;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.Roster.SubscriptionMode;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

import deus.core.access.transport.plugins.xmpp.common.FilteredPacketListener;
import deus.core.access.transport.plugins.xmpp.common.XmppConversation;
import deus.core.access.transport.plugins.xmpp.core.protocol.XmppTransportId;

// TODO: think about synchronization issues (e.g. with adding/removing of packet listeners)
public class XmppConversationImpl implements XmppConversation {

	private final XMPPConnection connection;
	private final XmppTransportId xmppTransportId;
	private final String password;

	private PacketListenerManager packetListenerManager;


	public XmppConversationImpl(XMPPConnection connection, XmppTransportId xmppTransportId, String password) {
		this.connection = connection;
		this.xmppTransportId = xmppTransportId;
		this.password = password;

		this.packetListenerManager = new PacketListenerManager(connection);
	}


	@Override
	public void connect() {
		try {
			connection.connect();
		}
		catch (XMPPException e) {
			// if the subscriber XMPP server is not available, something fatal went wrong!
			throw new RuntimeException("the local XMPP server of the user " + xmppTransportId + " is not available", e);
		}
	}


	@Override
	public boolean isConnected() {
		return connection.isConnected();
	}


	private void assertIsConnected() throws IllegalStateException {
		if (!isConnected())
			throw new IllegalStateException("Not connected to XMPP account " + xmppTransportId + " yet!");
	}


	@Override
	public void login() {
		assertIsConnected();

		try {
			connection.login(xmppTransportId.getXmppUsername(), password);

			// TODO: remove again and think about a better place for this (roster, subscriptionmode)
			getRoster().setSubscriptionMode(SubscriptionMode.manual);
		}
		catch (XMPPException e) {
			// if the the user cannot be logged in his local XMPP server, something fatal went wrong!
			throw new RuntimeException("the XMPP user " + xmppTransportId
					+ " cannot be logged in his local XMPP server", e);
		}
	}


	@Override
	public boolean isLoggedIn() {
		return connection.isAuthenticated();
	}


	private void assertIsLoggedIn() throws IllegalStateException {
		if (!isLoggedIn())
			throw new IllegalStateException("Not logged into XMPP account " + xmppTransportId + " yet!");
	}


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
		assertIsLoggedIn();

		return connection.getRoster();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.nsi.xmpp.common.XmppConversation#clearRoster()
	 */
	@Override
	public void clearRoster() {
		assertIsLoggedIn();

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
	 * deus.core.access.storage.user.model.id.XmppUserId)
	 */
	@Override
	public void sendPacket(Packet packet, XmppTransportId receiver) {
		assertIsLoggedIn();

		packet.setTo(receiver.toString());
		packet.setFrom(xmppTransportId.toString());
		// TODO: REMOVE
		//packet.setProperty(xmppConfiguration.getXmppPropertyFullName(), userMetadata.getFullName());
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
		assertIsConnected();

		// if we are only connected here, and not logged in, we could have missed some packets, when adding listener
		// now!

		packetListenerManager.addPacketListener(packetListener, packetFilter);
	}


	@Override
	public void addFilteredPacketListener(FilteredPacketListener filteredPacketListener) {
		addPacketListener(filteredPacketListener.getPacketListener(), filteredPacketListener.getFilter());
	}


	@Override
	public void removePacketListener(PacketListener packetListener) {
		assertIsConnected();

		// if we are only connected here, and not logged in, we could have missed some packets, when adding listener
		// now!

		packetListenerManager.removePacketListener(packetListener);
	}


	@Override
	public void removeAllPacketListeneres() {
		assertIsConnected();

		// if we are only connected here, and not logged in, we could have missed some packets, when adding listener
		// now!

		packetListenerManager.removeAllPacketListeners();
	}


}
