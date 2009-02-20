package deus.core.access.transport.core.soul.observers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.soul.mapper.UserIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.core.soul.protocol.TransportProtocol;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.gatekeeper.registrator.UserRegistrationStateObserver;
import deus.model.user.id.UserId;

@Component
public class TransportProtocolRegisterUserRegistrationStateObserver implements UserRegistrationStateObserver {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;
	
	
	@Override
	public void registered(UserId userId) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransportId transportId = userIdMapper.resolveLocal(userId);
			tp.getRegistrationEventCallback().registered(transportId);
		}
	}


	@Override
	public void unregistered(UserId userId) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransportId transportId = userIdMapper.resolveLocal(userId);
			tp.getRegistrationEventCallback().unregistered(transportId);
		}
	}

}
