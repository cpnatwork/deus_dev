package deus.core.access.transfer.plugins.xmpp.connectionstate;

import deus.core.access.transfer.core.connectionstate.ConnectionState;
import deus.core.access.transfer.plugins.xmpp.common.XmppConversation;

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
