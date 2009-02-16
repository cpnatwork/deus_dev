package deus.core.access.transport.core.soul.discovery;

import deus.model.user.id.UserId;

public interface TransportProtocolDiscoveryStrategy {

	public String agreeOnTransportProtocol(UserId receiverId);

}
