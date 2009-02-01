package deus.core.transport.commandexecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.TransportProtocol;
import deus.core.transport.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.transport.id.TransportIdUserIdMapper;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.sender.MessageSender;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;

@Component
class TransportMessageSenderHelper {

	@Autowired
	private TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;


	public void send(UserId receiverId, UserId senderId, TransportMessage transportMessage) {
		// agree on transport protocol
		String transportProtocolId = transportProtocolDiscoveryStrategy.agreeOnTransportProtocol(receiverId);
		TransportProtocol transportProtocol = transportProtocolRegistry
				.getRegisteredTransportProtocol(transportProtocolId);

		// set TIDs of sender and receiver
		TransportIdUserIdMapper transportIdFactory = transportProtocol.getTransportIdUserIdMapper();
		transportMessage.setReceiverTid(transportProtocolDiscoveryStrategy.getTransportId(transportProtocolId,
				receiverId));
		transportMessage.setSenderTid(transportIdFactory.map(senderId));

		// send mesg
		MessageSender messageSender = transportProtocol.getMessageSender();
		messageSender.send(transportMessage);
	}

}
