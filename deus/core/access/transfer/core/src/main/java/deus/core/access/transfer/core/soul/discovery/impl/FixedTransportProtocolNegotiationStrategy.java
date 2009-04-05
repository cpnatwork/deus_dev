package deus.core.access.transfer.core.soul.discovery.impl;

import deus.core.access.transfer.core.soul.discovery.TransportProtocolNegotiationStrategy;
import deus.model.user.id.UserId;

public class FixedTransportProtocolNegotiationStrategy implements TransportProtocolNegotiationStrategy {

	private final String transportProtocolId;


	public FixedTransportProtocolNegotiationStrategy(String transportProtocolId) {
		super();
		this.transportProtocolId = transportProtocolId;
	}


	@Override
	public String negotiateTransportProtocol(@SuppressWarnings("unused") UserId receiverId) {
		return transportProtocolId;
	}

}
