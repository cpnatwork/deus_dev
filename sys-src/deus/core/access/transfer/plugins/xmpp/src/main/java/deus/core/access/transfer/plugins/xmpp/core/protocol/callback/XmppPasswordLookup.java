package deus.core.access.transfer.plugins.xmpp.core.protocol.callback;

import deus.core.access.transfer.plugins.xmpp.core.protocol.XmppTransferId;


public interface XmppPasswordLookup {

	public String getPassword(XmppTransferId xmppTransferId);

}
