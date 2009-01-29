package deus.transport.xmpp.callback;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.callback.LoginEventCallback;
import deus.core.transport.connectionstate.ConnectionStateRegistry;
import deus.core.transport.id.TransportId;
import deus.model.user.UserMetadata;
import deus.transport.xmpp.common.XmppConversation;
import deus.transport.xmpp.common.XmppNetwork;
import deus.transport.xmpp.common.packetlistener.FilteredPacketListener;
import deus.transport.xmpp.common.packetlistener.SubscribePacketListener;
import deus.transport.xmpp.common.packetlistener.UnsubscribePacketListener;
import deus.transport.xmpp.common.packetlistener.UpdatePacketListener;
import deus.transport.xmpp.connectionstate.XmppConnectionState;
import deus.transport.xmpp.id.XmppTransportId;

public class XmppLoginEventCallback implements LoginEventCallback {

	@Autowired
	private XmppNetwork xmppNetwork;

	@Autowired
	private ConnectionStateRegistry connectionStateRegistry;


	@Override
	public void loggedIn(UserMetadata userMetadata, TransportId transportId, String password) {
		XmppConversation xmppConversation = xmppNetwork.createConversation(userMetadata, (XmppTransportId)transportId, password);

		// CONNECT
		xmppConversation.connect();

		addPacketListeners(xmppConversation, userMetadata);

		// LOGIN
		xmppConversation.login();

		XmppConnectionState xmppConnectionState = new XmppConnectionState(xmppConversation);

		connectionStateRegistry.addConnectionState(transportId, xmppConnectionState);
	}


	// TODO: refactor
	private void addPacketListeners(XmppConversation xmppConversation, UserMetadata userMetadata) {
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
