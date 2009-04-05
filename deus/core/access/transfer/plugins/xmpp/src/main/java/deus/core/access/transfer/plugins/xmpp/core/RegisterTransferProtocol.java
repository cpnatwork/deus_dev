package deus.core.access.transfer.plugins.xmpp.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.common.protocolregistry.TransferProtocolRegistry;

@Component
public class RegisterTransferProtocol {

	@Autowired
	private TransferProtocolRegistry transferProtocolRegistry;

	@Autowired
	private TransferProtocol transferProtocol;

	
	@PostConstruct
	public void register() {
		transferProtocolRegistry.registerTransferProtocol(transferProtocol);
	}


	@PreDestroy
	public void unregister() {
		transferProtocolRegistry.unregisterTransferProtocol(transferProtocol.getProtocolId());
	}

}
