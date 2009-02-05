package deus.core.transport.core.discovery;

import deus.core.transport.core.protocol.TransportId;
import deus.model.user.id.UserId;

public interface TransportProtocolDiscoveryStrategy {

	public String agreeOnTransportProtocol(UserId receiverId);
	
	@Deprecated
	public TransportId resolveTransportId(String transportProtocolId, UserId receiverId);
	
	@Deprecated
	public UserId resolveUserId(String transportProtocolId, TransportId receiverTpId);
	
}
