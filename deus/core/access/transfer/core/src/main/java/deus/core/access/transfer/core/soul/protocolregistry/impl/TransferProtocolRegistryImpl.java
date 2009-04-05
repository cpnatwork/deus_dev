package deus.core.access.transfer.core.soul.protocolregistry.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.soul.protocol.TransferProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.TransferProtocolRegistry;

@Component("transportProtocolRegistry")
public class TransferProtocolRegistryImpl implements TransferProtocolRegistry {

	private final Map<String, TransferProtocol> registeredTransportProtocols;


	public TransferProtocolRegistryImpl() {
		super();
		this.registeredTransportProtocols = new HashMap<String, TransferProtocol>();
	}


	@Override
	public TransferProtocol getRegisteredTransportProtocol(String transportProtocolId) {
		return registeredTransportProtocols.get(transportProtocolId);
	}


	@Override
	public void registerTransportProtocol(TransferProtocol transferProtocol) {
		if (registeredTransportProtocols.containsKey(transferProtocol.getId()))
			throw new IllegalArgumentException("transport protocol " + transferProtocol
					+ " has already been registered!");

		registeredTransportProtocols.put(transferProtocol.getId(), transferProtocol);
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
