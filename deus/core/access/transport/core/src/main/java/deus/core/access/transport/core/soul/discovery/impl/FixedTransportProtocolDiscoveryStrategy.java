package deus.core.access.transport.core.soul.discovery.impl;

import deus.core.access.transport.core.soul.discovery.TransportProtocolDiscoveryStrategy;
import deus.model.user.id.UserId;

public class FixedTransportProtocolDiscoveryStrategy implements TransportProtocolDiscoveryStrategy {

	private final String transportProtocolId;


	public FixedTransportProtocolDiscoveryStrategy(String transportProtocolId) {
		super();
		this.transportProtocolId = transportProtocolId;
	}


	@Override
	public String agreeOnTransportProtocol(@SuppressWarnings("unused") UserId receiverId) {
		return transportProtocolId;
	}

}
