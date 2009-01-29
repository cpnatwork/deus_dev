package deus.transport.local;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.core.transport.receiver.RemoteCommandReceiver;
import deus.transport.local.sender.LocalRemoteCommandSender;

public class RegisterTransportProtocol {

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private TransportProtocol localTransportProtocol;

	@Autowired
	private LocalRemoteCommandSender localRemoteCommandSender;


	@PostConstruct
	public void register() {
		RemoteCommandReceiver rcr = transportProtocolRegistry
				.registerTransportProtocol("local", localTransportProtocol);

		// connect rcr to rcs
		localRemoteCommandSender.setRemoteCommandReceiver(rcr);
	}


	@PreDestroy
	public void unregister() {
		transportProtocolRegistry.unregisterTransportProtocol("local");

		localRemoteCommandSender.setRemoteCommandReceiver(null);
	}

}
