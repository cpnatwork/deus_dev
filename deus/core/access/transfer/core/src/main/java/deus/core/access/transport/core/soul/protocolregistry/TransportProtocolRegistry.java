package deus.core.access.transport.core.soul.protocolregistry;

import java.util.Collection;

import deus.core.access.transport.core.soul.protocol.TransportProtocol;

public interface TransportProtocolRegistry extends ExportedTransportProtocolRegistry {

	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId);


	public Collection<String> getAllRegisteredTransportProtocolIds();
	
}
