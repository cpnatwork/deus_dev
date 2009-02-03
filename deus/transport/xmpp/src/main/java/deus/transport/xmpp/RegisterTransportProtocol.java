package deus.transport.xmpp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.core.protocol.TransportProtocol;
import deus.core.transport.core.protocolregistry.TransportProtocolRegistry;
import deus.core.transport.receiving.message.MessageReceiver;

public class RegisterTransportProtocol {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportProtocol transportProtocol;

	
	@PostConstruct
	public void register() {
		// FIXME: how to inject this into packet listeners
		MessageReceiver mr = transportProtocolRegistry
				.registerTransportProtocol(transportProtocol);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol(transportProtocol.getId());
	}

}
