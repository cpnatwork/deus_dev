package deus.core.access.transfer.core.soul.discovery;

import deus.model.user.id.UserId;


public interface TransportProtocolNegotiationStrategy {

	// TODO: maybe, TpID resolution can be done during TP negotiation	
	
	public String negotiateTransportProtocol(UserId receiverId);

}
