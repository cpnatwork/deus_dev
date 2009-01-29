package deus.transport.xmpp.id;

import deus.core.transport.id.LocalUserTransportIdFactory;
import deus.core.transport.id.TransportId;
import deus.model.user.id.UserId;

public class XmppLocalUserTransportIdFactory implements LocalUserTransportIdFactory {

	@Override
	public TransportId createTransportId(UserId userId) {
		// FIXME: create XmppTransportId from UserId
		return new XmppTransportId();
	}

}
