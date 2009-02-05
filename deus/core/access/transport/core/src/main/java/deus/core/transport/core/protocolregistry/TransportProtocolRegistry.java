package deus.core.transport.core.protocolregistry;

import java.util.Collection;

import deus.core.transport.core.protocol.TransportProtocol;

public interface TransportProtocolRegistry {

	public void registerTransportProtocol(TransportProtocol transportProtocol);


	public void unregisterTransportProtocol(String transportProtocolId);


	// TODO: don't export these method with OSGi
	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId);
	
	public Collection<String> getAllRegisteredTransportProtocolIds();
}
