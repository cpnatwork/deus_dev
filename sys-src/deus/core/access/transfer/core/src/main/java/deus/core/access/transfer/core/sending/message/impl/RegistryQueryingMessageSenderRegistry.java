package deus.core.access.transfer.core.sending.message.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.protocol.messagesender.MessageSender;
import deus.core.access.transfer.core.sending.message.MessageSenderRegistry;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;

@Named
public class RegistryQueryingMessageSenderRegistry implements MessageSenderRegistry {

	@Inject
	private QueriableTransferProtocolRegistry registry;
	
	@Override
	public MessageSender getMessageSender(String transferProtocolId) {
		return registry.getRegisteredTransferProtocol(transferProtocolId).getMessageSender();
	}

}
