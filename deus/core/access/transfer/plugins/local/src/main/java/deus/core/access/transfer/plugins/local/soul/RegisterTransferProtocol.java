package deus.core.access.transfer.plugins.local.soul;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.soul.protocol.TransferProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.ExportedTransferProtocolRegistry;

@Component
public class RegisterTransferProtocol {

	@Autowired
	private ExportedTransferProtocolRegistry registry;

	@Autowired
	private TransferProtocol loopbackProtocol;

	
	@PostConstruct
	public void register() {
		registry.registerTransferProtocol(loopbackProtocol);
	}


	@PreDestroy
	public void unregister() {
		registry.unregisterTransferProtocol(loopbackProtocol.getId());
	}

}
