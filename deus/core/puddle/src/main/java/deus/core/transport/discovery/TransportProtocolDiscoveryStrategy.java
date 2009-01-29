package deus.core.transport.discovery;

import deus.core.transport.id.TransportId;
import deus.model.user.id.UserId;

public interface TransportProtocolDiscoveryStrategy {

	public String agreeOnTransportProtocol(UserId receiverId);
	
	public TransportId getTransportId(String transportProtocolId, UserId receiverId);
	
}
