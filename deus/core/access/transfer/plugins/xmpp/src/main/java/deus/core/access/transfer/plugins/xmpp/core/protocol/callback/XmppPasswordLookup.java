package deus.core.access.transfer.plugins.xmpp.core.protocol.callback;

import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransportId;


public interface XmppPasswordLookup {

	public String getPassword(XmppTransportId xmppTransportId);

}
