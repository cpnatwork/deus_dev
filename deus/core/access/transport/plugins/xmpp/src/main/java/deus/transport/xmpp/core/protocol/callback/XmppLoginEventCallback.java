package deus.transport.xmpp.core.protocol.callback;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.connectionstate.ConnectionStateRegistry;
import deus.core.transport.core.protocol.TransportId;
import deus.core.transport.core.protocol.callback.LoginEventCallback;
import deus.transport.xmpp.common.FilteredPacketListener;
import deus.transport.xmpp.common.XmppConversation;
import deus.transport.xmpp.common.XmppNetwork;
import deus.transport.xmpp.connectionstate.XmppConnectionState;
import deus.transport.xmpp.core.protocol.XmppTransportId;
import deus.transport.xmpp.receiving.packetlistener.SubscribePacketListener;
import deus.transport.xmpp.receiving.packetlistener.UnsubscribePacketListener;
import deus.transport.xmpp.receiving.packetlistener.UpdatePacketListener;

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
