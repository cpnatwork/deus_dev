package deus.core.access.transfer.plugins.xmpp.core.protocol.callback;

import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransportId;

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
