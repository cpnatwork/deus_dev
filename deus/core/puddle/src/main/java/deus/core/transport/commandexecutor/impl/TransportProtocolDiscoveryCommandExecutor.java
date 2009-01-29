package deus.core.transport.commandexecutor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.TransportProtocol;
import deus.core.transport.command.Command;
import deus.core.transport.commandexecutor.CommandExecutor;
import deus.core.transport.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.transport.id.LocalUserTransportIdFactory;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.core.transport.sender.RemoteCommandSender;

@Component
public class TransportProtocolDiscoveryCommandExecutor implements CommandExecutor {

	@Autowired
	private TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;


	@Override
	public void execute(Command command) {
		// AGREE ON TRANSPORT PROTOCOL
		String transportProtocolId = transportProtocolDiscoveryStrategy.agreeOnTransportProtocol(command
				.getReceiverId());
		
		TransportProtocol transportProtocol = transportProtocolRegistry
				.getRegisteredTransportProtocol(transportProtocolId);
		
		RemoteCommandSender rcs = transportProtocol.getRemoteCommandSender();
		LocalUserTransportIdFactory transportIdFactory = transportProtocol.getLocalUserTransportIdFactory();
		
		// TID OF LOCAL USER IS GENERATED USING FACTORY!
		// TID OF REMOTE USER IS LOOKED UP USING DISCOVERY!!
		rcs.send(command, transportIdFactory.createTransportId(command.getSenderMetadata().getUserId()),
				transportProtocolDiscoveryStrategy.getTransportId(transportProtocolId, command.getReceiverId()));
	}

}
