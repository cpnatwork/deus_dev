package deus.core.transport.sending.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.core.protocol.MessageSender;
import deus.core.transport.core.protocolregistry.TransportProtocolRegistry;
import deus.core.transport.sending.message.MessageSenderRegistry;

@Component
public class RegistryQueryingMessageSenderRegistry implements MessageSenderRegistry {

	@Autowired
	private TransportProtocolRegistry registry;
	
	@Override
	public MessageSender getMessageSender(String transportProtocolId) {
		return registry.getRegisteredTransportProtocol(transportProtocolId).getMessageSender();
	}

}
