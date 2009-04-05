package deus.core.access.transfer.core.soul.observers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.TransportId;
import deus.core.access.transfer.core.soul.protocol.TransportProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.gatekeeper.cerberus.UserLoginStateObserver;
import deus.model.user.id.UserId;

@Component
public class TransportProtocolLoginUserLoginStateObserver implements UserLoginStateObserver {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;
	
	@Override
	public void loggedIn(UserId userId) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransportId transportId = userIdMapper.resolveLocal(userId);
			tp.getLoginEventCallback().loggedIn(transportId);
		}
	}


	@Override
	public void loggedOut(UserId userId) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransportId transportId = userIdMapper.resolveLocal(userId);
			tp.getLoginEventCallback().loggedOut(transportId);
		}
	}

}
