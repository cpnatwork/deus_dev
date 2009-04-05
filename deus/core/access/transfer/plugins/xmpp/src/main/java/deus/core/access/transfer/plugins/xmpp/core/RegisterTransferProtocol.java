package deus.core.access.transfer.plugins.xmpp.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.soul.protocol.TransferProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.ExportedTransferProtocolRegistry;

@Component
public class RegisterTransferProtocol {

	@Autowired
	private ExportedTransferProtocolRegistry transferProtocolRegistry;

	@Autowired
	private TransferProtocol transferProtocol;

	
	@PostConstruct
	public void register() {
		transferProtocolRegistry.registerTransferProtocol(transferProtocol);
	}


	@PreDestroy
	public void unregister() {
		transferProtocolRegistry.unregisterTransferProtocol(transferProtocol.getId());
	}

}
