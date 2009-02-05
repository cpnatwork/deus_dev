package deus.core.access.transport.plugins.xmpp.core.protocol.callback;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.access.transport.plugins.xmpp.common.FilteredPacketListener;
import deus.core.access.transport.plugins.xmpp.common.XmppConversation;
import deus.core.access.transport.plugins.xmpp.common.XmppNetwork;
import deus.core.access.transport.plugins.xmpp.connectionstate.XmppConnectionState;
import deus.core.access.transport.plugins.xmpp.core.protocol.XmppTransportId;
import deus.core.access.transport.plugins.xmpp.receiving.packetlistener.SubscribePacketListener;
import deus.core.access.transport.plugins.xmpp.receiving.packetlistener.UnsubscribePacketListener;
import deus.core.access.transport.plugins.xmpp.receiving.packetlistener.UpdatePacketListener;
import deus.core.transport.connectionstate.ConnectionStateRegistry;
import deus.core.transport.core.protocol.TransportId;
import deus.core.transport.core.protocol.callback.LoginEventCallback;

public class XmppLoginEventCallback implements LoginEventCallback {

	@Autowired
	private XmppNetwork xmppNetwork;
	
	@Autowired
	private XmppPasswordLookup xmppPasswordLookup;

	@Autowired
	private ConnectionStateRegistry connectionStateRegistry;


	@Override
	public void loggedIn(TransportId transportId) {
		String password = xmppPasswordLookup.getPassword((XmppTransportId)transportId);
		XmppConversation xmppConversation = xmppNetwork.createConversation((XmppTransportId)transportId, password);

		// CONNECT
		xmppConversation.connect();

		addPacketListeners(xmppConversation);

		// LOGIN
		xmppConversation.login();

		XmppConnectionState xmppConnectionState = new XmppConnectionState(xmppConversation);

		connectionStateRegistry.addConnectionState(transportId, xmppConnectionState);
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
	public void loggedOut(TransportId transportId) {
		XmppConnectionState xmppConnectionState = (XmppConnectionState) connectionStateRegistry.getConnectionState(transportId);

		XmppConversation xmppConversation = xmppConnectionState.getXmppConversation();
		
		xmppConversation.removeAllPacketListeneres();

		// TODO: think whether packages can be lost between removing packet listeners and this call for end()
		xmppConversation.end();
		
		connectionStateRegistry.removeConnectionState(transportId);
	}

}
