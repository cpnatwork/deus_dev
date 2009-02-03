package deus.transport.local.core.protocol;

import javax.annotation.Resource;

import deus.core.transport.core.protocol.AbstractTransportProtocol;

public class LocalTransportProtocol extends AbstractTransportProtocol {

	@Resource(name="transportProtocolId")
	private String transportProtocolId;
	
	@Override
	public String getId() {
		return transportProtocolId;
	}

}
