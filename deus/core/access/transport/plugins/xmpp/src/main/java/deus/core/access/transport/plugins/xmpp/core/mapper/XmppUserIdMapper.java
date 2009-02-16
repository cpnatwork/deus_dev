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
		// FIXME: this is actually done by discovery, right? so it should go to the transport-core-package!

		return null;
	}

}
