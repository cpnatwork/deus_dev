package deus.core.access.transport.core.soul.protocolregistry;

import deus.core.access.transport.core.soul.protocol.TransportProtocol;


public interface ExportedTransportProtocolRegistry {

	public abstract void registerTransportProtocol(TransportProtocol transportProtocol);


	public abstract void unregisterTransportProtocol(String transportProtocolId);

}