package deus.core.access.transfer.common.protocolregistry;

import deus.core.access.transfer.common.protocol.TransferProtocol;


public interface TransferProtocolRegistry {

	public abstract void registerTransferProtocol(TransferProtocol transferProtocol);


	public abstract void unregisterTransferProtocol(String transferProtocolId);

}