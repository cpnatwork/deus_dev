package deus.core.access.transport.plugins.xmpp.connectionstate;

import deus.core.access.transport.plugins.xmpp.common.XmppConversation;
import deus.core.transport.connectionstate.ConnectionState;

public class XmppConnectionState implements ConnectionState {

	private final XmppConversation xmppConversation;


	public XmppConnectionState(XmppConversation xmppConversation) {
		super();
		this.xmppConversation = xmppConversation;
	}


	public XmppConversation getXmppConversation() {
		return xmppConversation;
	}


	@Override
	public boolean isConnectionEstablished() {
		return xmppConversation.isLoggedIn();
	}

}
