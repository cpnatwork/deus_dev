package deus.core.access.transport.plugins.xmpp.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.soul.protocol.TransportProtocol;
import deus.core.access.transport.core.soul.protocolregistry.ExportedTransportProtocolRegistry;

@Component
public class RegisterTransportProtocol {

	@Autowired
	private ExportedTransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportProtocol transportProtocol;

	
	@PostConstruct
	public void register() {
		transportProtocolRegistry.registerTransportProtocol(transportProtocol);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol(transportProtocol.getId());
	}

}
