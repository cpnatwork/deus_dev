package deus.core.access.transfer.core.soul.protocolregistry;

import deus.core.access.transfer.core.soul.protocol.TransferProtocol;


public interface ExportedTransferProtocolRegistry {

	public abstract void registerTransportProtocol(TransferProtocol transferProtocol);


	public abstract void unregisterTransportProtocol(String transportProtocolId);

}