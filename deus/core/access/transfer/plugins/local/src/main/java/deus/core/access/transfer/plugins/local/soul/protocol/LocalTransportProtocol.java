package deus.core.access.transfer.plugins.local.soul.protocol;

import javax.annotation.Resource;

import deus.core.access.transfer.core.soul.protocol.AbstractTransportProtocol;

public class LocalTransportProtocol extends AbstractTransportProtocol {

	@Resource(name="transportProtocolId")
	private String transportProtocolId;
	
	@Override
	public String getId() {
		return transportProtocolId;
	}

}
