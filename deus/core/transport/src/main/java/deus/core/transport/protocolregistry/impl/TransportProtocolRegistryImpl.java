package deus.core.transport.protocolregistry.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.message.receiver.impl.DelegateToCommandReceiverMessageReceiver;
import deus.core.transport.protocol.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;

@Component
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
	public MessageReceiver registerTransportProtocol(TransportProtocol transportProtocol) {
		if (registeredTransportProtocols.containsKey(transportProtocol.getId()))
			throw new IllegalArgumentException("transport protocol " + transportProtocol
					+ " has already been registered!");

		registeredTransportProtocols.put(transportProtocol.getId(), transportProtocol);

		return new DelegateToCommandReceiverMessageReceiver(transportProtocol.getId(), transportProtocol
				.getTransportIdUserIdMapper());
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
