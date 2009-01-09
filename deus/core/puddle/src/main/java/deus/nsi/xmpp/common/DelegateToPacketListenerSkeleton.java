package deus.nsi.xmpp.common;

import java.util.ArrayList;
import java.util.List;

import org.jivesoftware.smack.XMPPConnection;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserIdType;
import deus.model.user.id.XmppUserId;
import deus.nsi.xmpp.common.packetfilter.FilteredPacketListener;


public class DelegateToPacketListenerSkeleton {

	private final LocalXmppServer localXmppServer;
	private final List<FilteredPacketListener> filteredPacketListeners;

	private final UserMetadata<XmppUserId> userMetadata;


	public DelegateToPacketListenerSkeleton(UserMetadata<XmppUserId> userMetadata) {
		this.localXmppServer = new LocalXmppServer();
		this.filteredPacketListeners = new ArrayList<FilteredPacketListener>();
		// TODO: think about this assert
		assert (userMetadata.getUserId().getType().equals(UserIdType.xmpp));
		this.userMetadata = userMetadata;
	}


	public void addPacketListener(FilteredPacketListener filteredPacketListener) {
		filteredPacketListeners.add(filteredPacketListener);
	}


	public void connect() {
		// connect to local XMPP account of the publisher
		XMPPConnection localConnection = localXmppServer.login(userMetadata.getUserId());

		for (FilteredPacketListener filteredPacketListener : filteredPacketListeners)
			localConnection.addPacketListener(filteredPacketListener, filteredPacketListener.getFilter());
	}

}