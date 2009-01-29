package deus.core.transport.protocolregistry;

import deus.core.transport.TransportProtocol;
import deus.core.transport.receiver.RemoteCommandReceiver;

public interface TransportProtocolRegistry {

	public RemoteCommandReceiver registerTransportProtocol(String transportProtocolId,
			TransportProtocol transportProtocol);


	public void unregisterTransportProtocol(String transportProtocolId);


	// TODO: don't export this method with OSGi
	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId);
}
