package deus.core.access.transport.plugins.xmpp.core.mapper;

import deus.core.access.transport.core.soul.mapper.UserIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public class XmppUserIdMapper implements UserIdMapper {

	@Override
	public TransportId resolveLocal(UserId userId, String transportProtocolId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TransportId resolveRemote(UserId userId, String transportProtocolId) {
		// TODO Auto-generated method stub
		return null;
	}

}
