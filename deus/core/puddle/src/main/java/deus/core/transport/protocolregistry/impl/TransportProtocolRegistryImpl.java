package deus.core.transport.protocolregistry.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.core.transport.receiver.RemoteCommandReceiver;

@Component
public class TransportProtocolRegistryImpl implements TransportProtocolRegistry {

	private final Map<String, TransportProtocol> registeredTransportProtocols;

	@Autowired
	private RemoteCommandReceiver remoteCommandReceiver;


	public TransportProtocolRegistryImpl() {
		super();
		this.registeredTransportProtocols = new HashMap<String, TransportProtocol>();
	}


	@Override
	public TransportProtocol getRegisteredTransportProtocol(String transportProtocolId) {
		return registeredTransportProtocols.get(transportProtocolId);
	}


	@Override
	public RemoteCommandReceiver registerTransportProtocol(String transportProtocolId,
			TransportProtocol transportProtocol) {
		if (registeredTransportProtocols.containsKey(transportProtocolId))
			throw new IllegalArgumentException("transport protocol " + transportProtocolId
					+ " has already been registered!");

		registeredTransportProtocols.put(transportProtocolId, transportProtocol);

		return remoteCommandReceiver;
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
