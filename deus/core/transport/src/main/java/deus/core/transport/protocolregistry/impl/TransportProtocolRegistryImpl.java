package deus.core.transport.protocolregistry.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocol.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;

@Component
public class TransportProtocolRegistryImpl implements TransportProtocolRegistry {

	private final Map<String, TransportProtocol> registeredTransportProtocols;

	@Autowired
	private MessageReceiver messageReceiver;


	public TransportProtocolRegistryImpl() {
		super();
		this.registeredTransportProtocols = new HashMap<String, TransportProtocol>();
	}


	@Override
	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId) {
		return registeredTransportProtocols.get(transportProtocolId);
	}


	@Override
	public MessageReceiver registerTransportProtocol(String transportProtocolId,
			TransportProtocol transportProtocol) {
		if (registeredTransportProtocols.containsKey(transportProtocolId))
			throw new IllegalArgumentException("transport protocol " + transportProtocolId
					+ " has already been registered!");

		registeredTransportProtocols.put(transportProtocolId, transportProtocol);

		return messageReceiver;
	}


	@Override
	public void unregisterTransportProtocol(String transportProtocolId) {
		if (!registeredTransportProtocols.containsKey(transportProtocolId))
			throw new IllegalArgumentException("transport protocol " + transportProtocolId + " was not registered!");
		registeredTransportProtocols.remove(transportProtocolId);
	}


	@Override
	public Collection<String> getAllRegisteredTransportProtocolIds() {
		return registeredTransportProtocols.keySet();
	}

}
