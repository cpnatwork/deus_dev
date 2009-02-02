package deus.transport.xmpp.callback;

import deus.transport.xmpp.id.XmppTransportId;

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
