package deus.core.access.transport.plugins.xmpp.core.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.access.transport.core.soul.mapper.UserIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.plugins.xmpp.common.XmppServerConnectionConfiguration;
import deus.core.access.transport.plugins.xmpp.core.protocol.XmppTransportId;
import deus.model.user.id.UserId;

public class XmppUserIdMapper implements UserIdMapper {

	@Autowired
	private XmppServerConnectionConfiguration xmppServerConnectionConfiguration;
	
	@Override
	public TransportId resolveLocal(UserId userId) {
		return new XmppTransportId(userId.getUsername(), xmppServerConnectionConfiguration.getLocalXmppServerAddress());
	}


	@Override
	public TransportId resolveRemote(UserId userId) {
		// FIXME: Implement this by using discovery
		// it should stay here, but maybe use discovery helper classes from transport-core

		return null;
	}

}
