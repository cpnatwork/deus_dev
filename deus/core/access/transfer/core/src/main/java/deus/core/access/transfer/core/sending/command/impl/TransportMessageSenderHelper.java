package deus.core.access.transfer.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.sending.message.MessageSenderRegistry;
import deus.core.access.transfer.core.soul.discovery.TransportProtocolNegotiationStrategy;
import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.MessageSender;
import deus.core.access.transfer.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;

@Component
public class TransportMessageSenderHelper {

	@Autowired
	private TransportProtocolNegotiationStrategy transportProtocolNegotiationStrategy;

	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;

	@Autowired
	private MessageSenderRegistry messageSenderRegistry;


	public void send(UserId receiverId, UserId senderId, TransportMessage transportMessage) {
		// agree on transport protocol
		String transportProtocolId = transportProtocolNegotiationStrategy.negotiateTransportProtocol(receiverId);

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
