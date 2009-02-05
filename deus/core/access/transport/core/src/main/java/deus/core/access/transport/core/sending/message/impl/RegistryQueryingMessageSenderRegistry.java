package deus.core.access.transport.core.sending.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.sending.message.MessageSenderRegistry;
import deus.core.access.transport.core.soul.protocol.MessageSender;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;

@Component
public class RegistryQueryingMessageSenderRegistry implements MessageSenderRegistry {

	@Autowired
	private TransportProtocolRegistry registry;
	
	@Override
	public MessageSender getMessageSender(String transportProtocolId) {
		return registry.getRegisteredTransportProtocol(transportProtocolId).getMessageSender();
	}

}
