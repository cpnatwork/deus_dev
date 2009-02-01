package deus.core.transport.observers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.gatekeeper.UserLoginStateObserver;
import deus.core.transport.TransportProtocol;
import deus.core.transport.id.TransportIdUserIdMapper;
import deus.core.transport.id.TransportId;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.model.user.UserMetadata;

@Component
public class UserLoginStateObserverImpl implements UserLoginStateObserver {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportIdUserIdMapper transportIdUserIdMapper;

	@Autowired
	private PasswordLookup passwordLookup;


	@Override
	public void loggedIn(UserMetadata userMetadata) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			TransportId transportId = transportIdUserIdMapper.map(userMetadata.getUserId());
			tp.getLoginEventCallback().loggedIn(transportId, passwordLookup.getPassword(transportId));
		}
	}


	@Override
	public void loggedOut(UserMetadata userMetadata) {
		for (String transportProtocolId : transportProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransportProtocol tp = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			tp.getLoginEventCallback().loggedOut(transportIdUserIdMapper.map(userMetadata.getUserId()));
		}
	}

}
