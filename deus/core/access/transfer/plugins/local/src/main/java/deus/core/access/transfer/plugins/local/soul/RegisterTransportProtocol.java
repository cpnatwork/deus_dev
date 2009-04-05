package deus.core.access.transfer.plugins.local.soul;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.soul.protocol.TransportProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.ExportedTransportProtocolRegistry;

@Component
public class RegisterTransportProtocol {

	@Autowired
	private ExportedTransportProtocolRegistry registry;

	@Autowired
	private TransportProtocol loopbackProtocol;

	
	@PostConstruct
	public void register() {
		registry.registerTransportProtocol(loopbackProtocol);
	}


	@PreDestroy
	public void unregister() {
		registry.unregisterTransportProtocol(loopbackProtocol.getId());
	}

}
