package deus.core.access.transfer.core.soul.protocolregistry;

import java.util.Collection;

import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.common.protocolregistry.TransferProtocolRegistry;

public interface QueriableTransferProtocolRegistry extends TransferProtocolRegistry {

	public TransferProtocol getRegisteredTransferProtocol(String transferProtocolId);


	public Collection<String> getAllRegisteredTransferProtocolIds();
	
}
