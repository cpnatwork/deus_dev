package deus.transport.local;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.TransportProtocol;
import deus.core.transport.message.receiver.MessageReceiver;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.transport.local.sender.LocalMessageSender;

public class RegisterTransportProtocol {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;
	
	@Resource(name="transportProtocolId")
	private String transportProtocolId;

	@Autowired
	private TransportProtocol localTransportProtocol;

	@Autowired
	private LocalMessageSender localMessageSender;


	@PostConstruct
	public void register() {
		MessageReceiver rcr = transportProtocolRegistry
				.registerTransportProtocol(transportProtocolId, localTransportProtocol);

		// connect rcr to rcs
		localMessageSender.setMessageReceiver(rcr);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol(transportProtocolId);

		localMessageSender.setMessageReceiver(null);
	}

}
