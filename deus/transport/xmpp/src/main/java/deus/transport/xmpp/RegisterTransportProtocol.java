package deus.transport.xmpp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.core.transport.receiver.RemoteCommandReceiver;

public class RegisterTransportProtocol {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportProtocol xmppTransportProtocol;

	
	@PostConstruct
	public void register() {
		// TODO: how to inject this into packet listeners
		RemoteCommandReceiver rcr = transportProtocolRegistry
				.registerTransportProtocol("local", xmppTransportProtocol);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol("local");
	}

}
