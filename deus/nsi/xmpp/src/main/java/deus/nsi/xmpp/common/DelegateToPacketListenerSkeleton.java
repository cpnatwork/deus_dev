package deus.nsi.xmpp.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster.SubscriptionMode;
import org.jivesoftware.smack.filter.PacketFilter;

import deus.nsi.xmpp.common.packetlistener.FilteredPacketListener;


public abstract class DelegateToPacketListenerSkeleton implements XmppSkeleton {

	private final XmppConversation userXmppConversation;
	private Map<PacketListener, PacketFilter> packetListeners;


	public DelegateToPacketListenerSkeleton(XmppConversation userXmppConversation) {
		this.userXmppConversation = userXmppConversation;
	}


	public void setPacketListeners(List<FilteredPacketListener> filteredPacketListeners) {
		packetListeners = new HashMap<PacketListener, PacketFilter>();
		for (FilteredPacketListener filteredPacketListener : filteredPacketListeners)
			packetListeners.put(filteredPacketListener.getPacketListener(), filteredPacketListener.getFilter());
	}


	// TODO: think about this signature: attach(XmppConversation)
	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppSkeleton#connect()
	 */
	public void connect() {
		// TODO: remove again and think about a better place for this
		userXmppConversation.getRoster().setSubscriptionMode(SubscriptionMode.manual);

		for (Map.Entry<PacketListener, PacketFilter> packetListenerEntry : packetListeners.entrySet())
			userXmppConversation.addPacketListener(packetListenerEntry.getKey(), packetListenerEntry.getValue());
	}


	// TODO: think about this signature: detach()
	/* (non-Javadoc)
	 * @see deus.nsi.xmpp.common.XmppSkeleton#disconnect()
	 */
	public void disconnect() {
		for (Map.Entry<PacketListener, PacketFilter> packetListenerEntry : packetListeners.entrySet())
			userXmppConversation.removePacketListener(packetListenerEntry.getKey());
	}
}