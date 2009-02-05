package deus.core.access.transport.core.soul.observers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.core.soul.protocol.TransportIdUserIdMapper;
import deus.core.access.transport.core.soul.protocol.TransportProtocol;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.gatekeeper.UserLoginStateObserver;
import deus.model.user.id.UserId;

@Component
public class TransportProtocolLoginUserLoginStateObserver implements UserLoginStateObserver {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Override
	public void loggedIn(UserId userId) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			TransportIdUserIdMapper transportIdUserIdMapper = tp.getTransportIdUserIdMapper();
			TransportId transportId = transportIdUserIdMapper.map(userId);
			tp.getLoginEventCallback().loggedIn(transportId);
		}
	}


	@Override
	public void loggedOut(UserId userId) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			TransportIdUserIdMapper transportIdUserIdMapper = tp.getTransportIdUserIdMapper();
			tp.getLoginEventCallback().loggedOut(transportIdUserIdMapper.map(userId));
		}
	}

}
