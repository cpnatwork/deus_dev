package deus.core.access.transfer.core.soul.protocolregistry;

import java.util.Collection;

import deus.core.access.transfer.core.soul.protocol.TransferProtocol;

public interface TransferProtocolRegistry extends ExportedTransferProtocolRegistry {

	public TransferProtocol getRegisteredTransferProtocol(String transferProtocolId);


	public Collection<String> getAllRegisteredTransferProtocolIds();
	
}
