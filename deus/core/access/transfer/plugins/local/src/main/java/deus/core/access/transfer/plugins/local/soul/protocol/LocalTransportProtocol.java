package deus.core.access.transfer.plugins.local.soul.protocol;

import javax.annotation.Resource;

import deus.core.access.transfer.core.soul.protocol.AbstractTransferProtocol;

public class LocalTransportProtocol extends AbstractTransferProtocol {

	@Resource(name="transportProtocolId")
	private String transportProtocolId;
	
	@Override
	public String getId() {
		return transportProtocolId;
	}

}
