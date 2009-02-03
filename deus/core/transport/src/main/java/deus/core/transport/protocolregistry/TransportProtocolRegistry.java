package deus.core.transport.protocolregistry;

import java.util.Collection;

import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocol.TransportProtocol;

public interface TransportProtocolRegistry {

	public MessageReceiver registerTransportProtocol(TransportProtocol transportProtocol);


	public void unregisterTransportProtocol(String transportProtocolId);


	// TODO: don't export these method with OSGi
	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId);
	
	public Collection<String> getAllRegisteredTransportProtocolIds();
}
