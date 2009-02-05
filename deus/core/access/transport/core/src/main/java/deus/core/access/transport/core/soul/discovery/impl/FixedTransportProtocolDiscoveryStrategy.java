package deus.core.access.transport.core.soul.discovery.impl;

import deus.core.access.transport.core.soul.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public class FixedTransportProtocolDiscoveryStrategy implements TransportProtocolDiscoveryStrategy {

	private final String transportProtocolId;


	public FixedTransportProtocolDiscoveryStrategy(String transportProtocolId) {
		super();
		this.transportProtocolId = transportProtocolId;
	}


	@Override
	public String agreeOnTransportProtocol(UserId receiverId) {
		return transportProtocolId;
	}


	@Override
	public TransportId resolveTransportId(String transportProtocolId, UserId receiverId) {
		// FIXME Auto-generated method stub
		return null;
	}


	@Override
	public UserId resolveUserId(String transportProtocolId, TransportId receiverTpId) {
		// FIXME Auto-generated method stub
		return null;
	}

}
