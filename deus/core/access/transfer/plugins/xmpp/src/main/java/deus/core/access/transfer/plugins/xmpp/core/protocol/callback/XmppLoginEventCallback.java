package deus.core.access.transfer.plugins.xmpp.core.protocol.callback;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.access.transfer.core.connectionstate.ConnectionStateRegistry;
import deus.core.access.transfer.core.soul.protocol.TransferId;
import deus.core.access.transfer.core.soul.protocol.callback.LoginEventCallback;
import deus.core.access.transfer.plugins.xmpp.common.FilteredPacketListener;
import deus.core.access.transfer.plugins.xmpp.common.XmppConversation;
import deus.core.access.transfer.plugins.xmpp.common.XmppNetwork;
import deus.core.access.transfer.plugins.xmpp.connectionstate.XmppConnectionState;
import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransportId;
import deus.core.access.transfer.plugins.xmpp.receiving.packetlistener.SubscribePacketListener;
import deus.core.access.transfer.plugins.xmpp.receiving.packetlistener.UnsubscribePacketListener;
import deus.core.access.transfer.plugins.xmpp.receiving.packetlistener.UpdatePacketListener;

public class XmppLoginEventCallback implements LoginEventCallback {

	@Autowired
	private XmppNetwork xmppNetwork;
	
	@Autowired
	private XmppPasswordLookup xmppPasswordLookup;

	@Autowired
	private ConnectionStateRegistry connectionStateRegistry;


	@Override
	public void loggedIn(TransferId transferId) {
		String password = xmppPasswordLookup.getPassword((XmppTransportId)transferId);
		XmppConversation xmppConversation = xmppNetwork.createConversation((XmppTransportId)transferId, password);

		// CONNECT
		xmppConversation.connect();

		addPacketListeners(xmppConversation);

		// LOGIN
		xmppConversation.login();

		XmppConnectionState xmppConnectionState = new XmppConnectionState(xmppConversation);

		connectionStateRegistry.addConnectionState(transferId, xmppConnectionState);
	}


	// TODO: refactor
	private void addPacketListeners(XmppConversation xmppConversation) {
		FilteredPacketListener subscribePacketListener = new SubscribePacketListener();
		xmppConversation.addFilteredPacketListener(subscribePacketListener);

		FilteredPacketListener unsubscribePacketListener = new UnsubscribePacketListener();
		xmppConversation.addFilteredPacketListener(unsubscribePacketListener);

		
		FilteredPacketListener updatePacketListener = new UpdatePacketListener();
		xmppConversation.addFilteredPacketListener(updatePacketListener);
	}


	@Override
	public void loggedOut(TransferId transferId) {
		XmppConnectionState xmppConnectionState = (XmppConnectionState) connectionStateRegistry.getConnectionState(transferId);

		XmppConversation xmppConversation = xmppConnectionState.getXmppConversation();
		
		xmppConversation.removeAllPacketListeneres();

		// TODO: think whether packages can be lost between removing packet listeners and this call for end()
		xmppConversation.end();
		
		connectionStateRegistry.removeConnectionState(transferId);
	}

}
