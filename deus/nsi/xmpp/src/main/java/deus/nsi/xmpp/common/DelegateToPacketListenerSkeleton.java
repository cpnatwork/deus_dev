package deus.nsi.xmpp.common;

import java.util.List;

import org.jivesoftware.smack.Roster.SubscriptionMode;

import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;


public class DelegateToPacketListenerSkeleton {

	private final XmppConversation userXmppConversation;
	private List<FilteredPacketListener> filteredPacketListeners;


	public DelegateToPacketListenerSkeleton(XmppConversation userXmppConversation) {
		this.userXmppConversation = userXmppConversation;
	}


	public void setPacketListeners(List<FilteredPacketListener> filteredPacketListeners) {
		this.filteredPacketListeners = filteredPacketListeners;
	}


	public void connect() {
		// TODO: remove again and think about a better place for this
		userXmppConversation.getRoster().setSubscriptionMode(SubscriptionMode.manual);

		for (FilteredPacketListener filteredPacketListener : filteredPacketListeners)
			userXmppConversation.addPacketListener(
					filteredPacketListener.getPacketListener(),
					filteredPacketListener.getFilter());
	}


	public void disconnect() {
		for (FilteredPacketListener filteredPacketListener : filteredPacketListeners)
			userXmppConversation.removePacketListener(filteredPacketListener.getPacketListener());
	}
}