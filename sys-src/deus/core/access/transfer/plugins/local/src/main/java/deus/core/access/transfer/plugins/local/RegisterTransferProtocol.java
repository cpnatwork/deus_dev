package deus.core.access.transfer.plugins.local;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.common.protocolregistry.TransferProtocolRegistry;

@Named
public class RegisterTransferProtocol {

	@Inject
	private TransferProtocolRegistry registry;

	@Inject
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
