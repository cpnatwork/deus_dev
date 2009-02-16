package deus.core.access.transport.core.soul.discovery;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public interface TransportProtocolDiscoveryStrategy {

	public String agreeOnTransportProtocol(UserId receiverId);
	
	@Deprecated
	public TransportId resolveTransportId(String transportProtocolId, UserId receiverId);
	
}
