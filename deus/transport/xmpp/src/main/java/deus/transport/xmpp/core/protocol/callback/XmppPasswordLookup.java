package deus.transport.xmpp.core.protocol.callback;

import deus.transport.xmpp.core.protocol.XmppTransportId;


public interface XmppPasswordLookup {

	public String getPassword(XmppTransportId xmppTransportId);

}
