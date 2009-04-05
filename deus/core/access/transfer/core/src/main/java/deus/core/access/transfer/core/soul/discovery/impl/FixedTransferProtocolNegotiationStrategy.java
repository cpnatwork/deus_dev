package deus.core.access.transfer.core.soul.discovery.impl;

import deus.core.access.transfer.core.soul.discovery.TransferProtocolNegotiationStrategy;
import deus.model.user.id.UserId;

public class FixedTransferProtocolNegotiationStrategy implements TransferProtocolNegotiationStrategy {

	private final String transportProtocolId;


	public FixedTransferProtocolNegotiationStrategy(String transportProtocolId) {
		super();
		this.transportProtocolId = transportProtocolId;
	}


	@Override
	public String negotiateTransportProtocol(@SuppressWarnings("unused") UserId receiverId) {
		return transportProtocolId;
	}

}
