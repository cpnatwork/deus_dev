package deus.transport.xmpp.core.protocol.callback;

import deus.transport.xmpp.core.protocol.XmppTransportId;

public class FixedPasswordLookup implements XmppPasswordLookup {

	private final String password;


	public FixedPasswordLookup(String password) {

		this.password = password;
	}


	@Override
	public String getPassword(XmppTransportId transportId) {
		return password;
	}

}
