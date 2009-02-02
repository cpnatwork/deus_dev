package deus.transport.xmpp.callback;

import deus.transport.xmpp.id.XmppTransportId;


public interface XmppPasswordLookup {

	public String getPassword(XmppTransportId xmppTransportId);

}
