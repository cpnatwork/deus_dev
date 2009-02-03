package deus.transport.local;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocol.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.transport.local.sender.LocalMessageSender;

public class RegisterTransportProtocol {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportProtocol transportProtocol;

	@Autowired
	private LocalMessageSender localMessageSender;


	@PostConstruct
	public void register() {
		MessageReceiver mr = transportProtocolRegistry
				.registerTransportProtocol(transportProtocol);

		// connect mr to ms
		localMessageSender.setMessageReceiver(mr);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol(transportProtocol.getId());

		localMessageSender.setMessageReceiver(null);
	}

}
