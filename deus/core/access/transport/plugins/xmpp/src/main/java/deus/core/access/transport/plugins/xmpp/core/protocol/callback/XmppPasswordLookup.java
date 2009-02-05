package deus.core.access.transport.plugins.xmpp.core.protocol.callback;

import deus.core.access.transport.plugins.xmpp.core.protocol.XmppTransportId;


public interface XmppPasswordLookup {

	public String getPassword(XmppTransportId xmppTransportId);

}
