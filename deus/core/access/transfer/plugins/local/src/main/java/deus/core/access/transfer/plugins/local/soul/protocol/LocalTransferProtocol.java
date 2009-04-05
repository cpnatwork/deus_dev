package deus.core.access.transfer.plugins.local.soul.protocol;

import javax.annotation.Resource;

import deus.core.access.transfer.core.soul.protocol.AbstractTransferProtocol;

public class LocalTransferProtocol extends AbstractTransferProtocol {

	@Resource(name="transferProtocolId")
	private String transferProtocolId;
	
	@Override
	public String getId() {
		return transferProtocolId;
	}

}
