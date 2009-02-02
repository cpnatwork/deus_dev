package deus.transport.xmpp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocol.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;

public class RegisterTransportProtocol {
	
	@Resource(name="transportProtocolId")
	private String transportProtocolId;

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportProtocol xmppTransportProtocol;

	
	@PostConstruct
	public void register() {
		// FIXME: how to inject this into packet listeners
		MessageReceiver mr = transportProtocolRegistry
				.registerTransportProtocol(transportProtocolId, xmppTransportProtocol);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol(transportProtocolId);
	}

}
