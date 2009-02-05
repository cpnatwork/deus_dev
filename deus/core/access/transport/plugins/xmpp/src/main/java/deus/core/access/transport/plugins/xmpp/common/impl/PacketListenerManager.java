package deus.core.access.transport.plugins.xmpp.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketFilter;

/**
 * Adds PacketListeners and PacketFilters to an XMPPConnection and wraps them, so that execeptions are catched.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class PacketListenerManager {

	// used to wrap packetListeners in ExceptionCatchingPacketListener
	private final Map<PacketListener, ExceptionCatchingPacketListener> addedPacketListeners;

	private final XMPPConnection connection;


	public PacketListenerManager(XMPPConnection connection) {
		this.addedPacketListeners = new HashMap<PacketListener, ExceptionCatchingPacketListener>();
		this.connection = connection;
	}


	public void addPacketListener(PacketListener packetListener, PacketFilter packetFilter) {
		if (packetListener == null)
			throw new IllegalArgumentException("PacketListener is null!");

		ExceptionCatchingPacketListener ecpl = new ExceptionCatchingPacketListener(packetListener);

		addedPacketListeners.put(packetListener, ecpl);

		// wrapping PacketListener and PacketFilter into exception catching ones
		connection.addPacketListener(ecpl, new ExceptionCatchingPacketFilter(packetFilter));
	}


	public void removePacketListener(PacketListener packetListener) {
		ExceptionCatchingPacketListener ecpl = addedPacketListeners.remove(packetListener);
		if (ecpl == null)
			throw new IllegalArgumentException("Can't remove PacketListener " + packetListener + ", it was not added!");
		connection.removePacketListener(ecpl);
	}


	public void removeAllPacketListeners() {
		for (PacketListener listener : addedPacketListeners.keySet())
			removePacketListener(listener);
	}

}