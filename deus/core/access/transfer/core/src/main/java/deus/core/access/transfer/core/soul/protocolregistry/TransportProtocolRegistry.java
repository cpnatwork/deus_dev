package deus.core.access.transfer.core.soul.protocolregistry;

import java.util.Collection;

import deus.core.access.transfer.core.soul.protocol.TransportProtocol;

public interface TransportProtocolRegistry extends ExportedTransportProtocolRegistry {

	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId);


	public Collection<String> getAllRegisteredTransportProtocolIds();
	
}
