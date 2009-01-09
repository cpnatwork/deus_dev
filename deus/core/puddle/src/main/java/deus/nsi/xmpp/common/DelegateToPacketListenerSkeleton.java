package deus.nsi.xmpp.common;

import java.util.List;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.Roster.SubscriptionMode;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;


public class DelegateToPacketListenerSkeleton {

	private final LocalXmppServer localXmppServer;
	private List<FilteredPacketListener> filteredPacketListeners;

	private final UserMetadata<XmppUserId> userMetadata;


	public DelegateToPacketListenerSkeleton(UserMetadata<XmppUserId> userMetadata) {
		this.localXmppServer = new LocalXmppServer();
		// TODO: think about this assert
		assert (userMetadata.getUserId().getType().equals(UserIdType.xmpp));
		this.userMetadata = userMetadata;
	}


	public void setPacketListeners(List<FilteredPacketListener> filteredPacketListeners) {
		this.filteredPacketListeners = filteredPacketListeners;
	}

	public void connect() {
		// connect to local XMPP account of the publisher
		XMPPConnection localConnection = localXmppServer.login(userMetadata.getUserId());
		// TODO: remove again and think about a better place for this
		localConnection.getRoster().setSubscriptionMode(SubscriptionMode.manual);

		for (FilteredPacketListener filteredPacketListener : filteredPacketListeners)
			localConnection.addPacketListener(filteredPacketListener, filteredPacketListener.getFilter());
	}

}