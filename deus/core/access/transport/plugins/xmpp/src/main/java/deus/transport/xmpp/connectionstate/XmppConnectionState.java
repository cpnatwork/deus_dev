package deus.transport.xmpp.connectionstate;

import deus.core.transport.connectionstate.ConnectionState;
import deus.transport.xmpp.common.XmppConversation;

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
