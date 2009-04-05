package deus.core.access.transfer.core.soul.protocolregistry;

import deus.core.access.transfer.core.soul.protocol.TransferProtocol;


public interface ExportedTransferProtocolRegistry {

	public abstract void registerTransferProtocol(TransferProtocol transferProtocol);


	public abstract void unregisterTransferProtocol(String transferProtocolId);

}