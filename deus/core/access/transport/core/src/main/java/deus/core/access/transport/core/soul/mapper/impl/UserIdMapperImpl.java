package deus.core.access.transport.core.soul.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.soul.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.access.transport.core.soul.mapper.UserIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;

//FIXME: think about this implementation!
@Component
public class UserIdMapperImpl implements UserIdMapper {


	@Autowired
	private TransportProtocolDiscoveryStrategy discovery;

	@Autowired
	private TransportProtocolRegistry registry;
	
	
	@Override
	public TransportId resolveLocal(UserId userId, String transportProtocolId) {
		return registry.getRegisteredTransportProtocol(transportProtocolId).getTransportIdUserIdMapper().map(userId);
	}

	@Override
	public TransportId resolveRemote(UserId userId, String transportProtocolId) {
		return discovery.resolveTransportId(transportProtocolId, userId);
	}

}
