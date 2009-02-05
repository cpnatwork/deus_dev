package deus.core.access.transport.core.soul.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.soul.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.access.transport.core.soul.mapper.TransportIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;

// FIXME: think about this implementation!
@Component
public class TransportIdMapperImpl implements TransportIdMapper {

	@Autowired
	private TransportProtocolDiscoveryStrategy discovery;

	@Autowired
	private TransportProtocolRegistry registry;
	
	@Override
	public UserId resolveLocal(TransportId transportId) {
		return registry.getRegisteredTransportProtocol(transportId.getTransportProtocolId()).getTransportIdUserIdMapper().map(transportId);
	}

	@Override
	public UserId resolveRemote(TransportId transportId) {
		return discovery.resolveUserId(transportId.getTransportProtocolId(), transportId);
	}

}
