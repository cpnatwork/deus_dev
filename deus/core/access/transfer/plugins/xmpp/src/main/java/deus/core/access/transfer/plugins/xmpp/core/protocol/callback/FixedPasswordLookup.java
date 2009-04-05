package deus.core.access.transfer.plugins.xmpp.core.protocol.callback;

import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransferId;

public class FixedPasswordLookup implements XmppPasswordLookup {

	private final String password;


	public FixedPasswordLookup(String password) {

		this.password = password;
	}


	@Override
	public String getPassword(XmppTransferId transportId) {
		return password;
	}

}
