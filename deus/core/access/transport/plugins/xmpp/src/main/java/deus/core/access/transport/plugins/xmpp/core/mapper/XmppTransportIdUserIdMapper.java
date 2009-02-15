package deus.core.access.transport.plugins.xmpp.core.mapper;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.core.soul.protocol.TransportIdUserIdMapper;
import deus.core.access.transport.plugins.xmpp.core.protocol.XmppTransportId;
import deus.model.user.id.UserId;

public class XmppTransportIdUserIdMapper implements TransportIdUserIdMapper {

	@Override
	public TransportId map(UserId userId) {
		// FIXME: create XmppTransportId from UserId
		return new XmppTransportId();
	}


	@Override
	public UserId map(TransportId transportId) {
		// FIXME: create UserId from XmppTransportId
		return null;
	}

}
