package deus.nsi.xmpp.common;

import java.util.List;

import org.jivesoftware.smack.Roster.SubscriptionMode;

import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;


public class DelegateToPacketListenerSkeleton {

	private final XmppAccount userXmppAccount;
	private List<FilteredPacketListener> filteredPacketListeners;


	public DelegateToPacketListenerSkeleton(XmppAccount userXmppAccount) {
		this.userXmppAccount = userXmppAccount;
	}


	public void setPacketListeners(List<FilteredPacketListener> filteredPacketListeners) {
		this.filteredPacketListeners = filteredPacketListeners;
	}


	public void connect() {
		// TODO: remove again and think about a better place for this
		userXmppAccount.getRoster().setSubscriptionMode(SubscriptionMode.manual);

		for (FilteredPacketListener filteredPacketListener : filteredPacketListeners)
			userXmppAccount.addPacketListener(filteredPacketListener);
	}

}