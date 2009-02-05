package deus.core.transport.core.protocolregistry.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import deus.core.transport.core.protocol.TransportProtocol;
import deus.core.transport.core.protocolregistry.TransportProtocolRegistry;

@Component("transportProtocolRegistry")
public class TransportProtocolRegistryImpl implements TransportProtocolRegistry {

	private final Map<String, TransportProtocol> registeredTransportProtocols;


	public TransportProtocolRegistryImpl() {
		super();
		this.registeredTransportProtocols = new HashMap<String, TransportProtocol>();
	}


	@Override
	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId) {
		return registeredTransportProtocols.get(transportProtocolId);
	}


	@Override
	public void registerTransportProtocol(TransportProtocol transportProtocol) {
		if (registeredTransportProtocols.containsKey(transportProtocol.getId()))
			throw new IllegalArgumentException("transport protocol " + transportProtocol
					+ " has already been registered!");

		registeredTransportProtocols.put(transportProtocol.getId(), transportProtocol);
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
