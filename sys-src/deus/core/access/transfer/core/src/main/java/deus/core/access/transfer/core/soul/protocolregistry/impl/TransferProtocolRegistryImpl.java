package deus.core.access.transfer.core.soul.protocolregistry.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;

@Named("transferProtocolRegistry")
public class TransferProtocolRegistryImpl implements QueriableTransferProtocolRegistry {

	private final Map<String, TransferProtocol> registeredTransferProtocols;


	public TransferProtocolRegistryImpl() {
		super();
		this.registeredTransferProtocols = new HashMap<String, TransferProtocol>();
	}


	@Override
	public TransferProtocol getRegisteredTransferProtocol(String transferProtocolId) {
		return registeredTransferProtocols.get(transferProtocolId);
	}


	@Override
	public void registerTransferProtocol(TransferProtocol transferProtocol) {
		if (registeredTransferProtocols.containsKey(transferProtocol.getProtocolId()))
			throw new IllegalArgumentException("transfer protocol " + transferProtocol
					+ " has already been registered!");

		registeredTransferProtocols.put(transferProtocol.getProtocolId(), transferProtocol);
	}


	@Override
	public void unregisterTransferProtocol(String transferProtocolId) {
		if (!registeredTransferProtocols.containsKey(transferProtocolId))
			throw new IllegalArgumentException("transfer protocol " + transferProtocolId + " was not registered!");
		registeredTransferProtocols.remove(transferProtocolId);
	}


	@Override
	public Collection<String> getAllRegisteredTransferProtocolIds() {
		return registeredTransferProtocols.keySet();
	}

}
