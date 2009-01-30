package deus.transport.xmpp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.TransportProtocol;
import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;

public class RegisterTransportProtocol {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportProtocol xmppTransportProtocol;

	
	@PostConstruct
	public void register() {
		// TODO: how to inject this into packet listeners
		MessageReceiver rcr = transportProtocolRegistry
				.registerTransportProtocol("local", xmppTransportProtocol);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol("local");
	}

}
