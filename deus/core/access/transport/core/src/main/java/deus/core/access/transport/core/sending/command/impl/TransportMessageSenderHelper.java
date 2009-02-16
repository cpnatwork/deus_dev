package deus.core.access.transport.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.sending.message.MessageSenderRegistry;
import deus.core.access.transport.core.soul.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.access.transport.core.soul.mapper.UserIdMapper;
import deus.core.access.transport.core.soul.protocol.MessageSender;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;

@Component
public class TransportMessageSenderHelper {

	@Autowired
	private TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private MessageSenderRegistry messageSenderRegistry;


	public void send(UserId receiverId, UserId senderId, TransportMessage transportMessage) {
		// agree on transport protocol
		String transportProtocolId = transportProtocolDiscoveryStrategy.agreeOnTransportProtocol(receiverId);

		UserIdMapper userIdMapper = transportProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId).getUserIdMapper();
		
		// set IDs of sender and receiver
		transportMessage.setSenderId(senderId);
		transportMessage.setReceiverId(receiverId);
		
		// set TIDs of sender and receiver
		transportMessage.setReceiverTid(userIdMapper.resolveRemote(receiverId));
		transportMessage.setSenderTid(userIdMapper.resolveLocal(senderId));

		// send msg
		MessageSender messageSender = messageSenderRegistry.getMessageSender(transportProtocolId);
		messageSender.send(transportMessage);
	}
}
