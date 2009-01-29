package deus.core.transport.observers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.gatekeeper.UserLoginStateObserver;
import deus.core.transport.TransportProtocol;
import deus.core.transport.id.LocalUserTransportIdFactory;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;

@Component
public class UserLoginStateObserverImpl implements UserLoginStateObserver {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;
	
	@Autowired
	private LocalUserTransportIdFactory tidFactory;
	
	@Override
	public void loggedIn(UserId userId) {
		for(String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			tp.getLoginEventCallback().loggedIn(tidFactory.createTransportId(userId));
		}
	}

	@Override
	public void loggedOut(UserId userId) {
		for(String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			tp.getLoginEventCallback().loggedOut(tidFactory.createTransportId(userId));
		}		
	}

}
