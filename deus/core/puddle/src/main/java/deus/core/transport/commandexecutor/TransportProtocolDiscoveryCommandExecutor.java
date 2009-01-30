package deus.core.transport.commandexecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.common.BarkerCommandExecutor;
import deus.core.transport.TransportProtocol;
import deus.core.transport.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.transport.id.TransportIdUserIdMapper;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.sender.MessageSender;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;

@Component
@Deprecated
public class TransportProtocolDiscoveryCommandExecutor implements BarkerCommandExecutor {

	@Autowired
	private TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;


	@Override
	public void execute(TransportMessage transportMessage) {
		// AGREE ON TRANSPORT PROTOCOL
		String transportProtocolId = transportProtocolDiscoveryStrategy.agreeOnTransportProtocol(transportMessage
				.getReceiverId());
		
		TransportProtocol transportProtocol = transportProtocolRegistry
				.getRegisteredTransportProtocol(transportProtocolId);
		
		MessageSender messageSender = transportProtocol.getMessageSender();
		TransportIdUserIdMapper transportIdFactory = transportProtocol.getTransportIdUserIdMapper();
		
		// TID OF LOCAL USER IS GENERATED USING FACTORY!
		// TID OF REMOTE USER IS LOOKED UP USING DISCOVERY!!
		messageSender.send(transportMessage, transportIdFactory.MAP(transportMessage.getSenderMetadata().getUserId()),
				transportProtocolDiscoveryStrategy.getTransportId(transportProtocolId, transportMessage.getReceiverId()));
	}

}
