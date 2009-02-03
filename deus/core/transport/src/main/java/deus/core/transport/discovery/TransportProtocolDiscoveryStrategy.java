package deus.core.transport.discovery;

import deus.core.transport.protocol.TransportId;
import deus.model.user.id.UserId;

public interface TransportProtocolDiscoveryStrategy {

	public String agreeOnTransportProtocol(UserId receiverId);
	
	// TODO: think about these two methods: do they really belong here, or into the concrete TP plugin? 
	public TransportId resolveTransportId(String transportProtocolId, UserId receiverId);
	
	public UserId resolveUserId(String transportProtocolId, TransportId receiverTpId);
	
}
