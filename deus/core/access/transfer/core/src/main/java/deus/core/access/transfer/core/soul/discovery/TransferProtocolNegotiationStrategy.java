package deus.core.access.transfer.core.soul.discovery;

import deus.model.user.id.UserId;


public interface TransferProtocolNegotiationStrategy {

	// TODO: maybe, TpID resolution can be done during TP negotiation	
	
	public String negotiateTransferProtocol(UserId receiverId);

}
