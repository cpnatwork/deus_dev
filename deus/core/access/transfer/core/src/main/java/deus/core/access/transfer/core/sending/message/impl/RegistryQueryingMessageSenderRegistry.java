package deus.core.access.transfer.core.sending.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.sending.message.MessageSenderRegistry;
import deus.core.access.transfer.core.soul.protocol.MessageSender;
import deus.core.access.transfer.core.soul.protocolregistry.TransferProtocolRegistry;

@Component
public class RegistryQueryingMessageSenderRegistry implements MessageSenderRegistry {

	@Autowired
	private TransferProtocolRegistry registry;
	
	@Override
	public MessageSender getMessageSender(String transferProtocolId) {
		return registry.getRegisteredTransferProtocol(transferProtocolId).getMessageSender();
	}

}
