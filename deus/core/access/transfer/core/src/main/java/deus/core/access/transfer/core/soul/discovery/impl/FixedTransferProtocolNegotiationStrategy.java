package deus.core.access.transfer.core.soul.discovery.impl;

import deus.core.access.transfer.core.soul.discovery.TransferProtocolNegotiationStrategy;
import deus.model.user.id.UserId;

public class FixedTransferProtocolNegotiationStrategy implements TransferProtocolNegotiationStrategy {

	private final String transferProtocolId;


	public FixedTransferProtocolNegotiationStrategy(String transferProtocolId) {
		super();
		this.transferProtocolId = transferProtocolId;
	}


	@Override
	public String negotiateTransferProtocol(@SuppressWarnings("unused") UserId receiverId) {
		return transferProtocolId;
	}

}
