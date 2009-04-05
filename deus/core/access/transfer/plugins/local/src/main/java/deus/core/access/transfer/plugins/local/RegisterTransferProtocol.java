package deus.core.access.transfer.plugins.local;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.common.protocolregistry.TransferProtocolRegistry;

@Component
public class RegisterTransferProtocol {

	@Autowired
	private TransferProtocolRegistry registry;

	@Autowired
	private TransferProtocol loopbackProtocol;

	
	@PostConstruct
	public void register() {
		registry.registerTransferProtocol(loopbackProtocol);
	}


	@PreDestroy
	public void unregister() {
		registry.unregisterTransferProtocol(loopbackProtocol.getProtocolId());
	}

}
