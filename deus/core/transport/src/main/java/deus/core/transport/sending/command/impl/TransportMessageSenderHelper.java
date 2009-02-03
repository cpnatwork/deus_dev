package deus.core.transport.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.transport.core.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.transport.core.mapper.UserIdMapper;
import deus.core.transport.core.protocol.MessageSender;
import deus.core.transport.messages.TransportMessage;
import deus.core.transport.sending.message.MessageSenderRegistry;
import deus.model.user.id.UserId;

@Component
public class TransportMessageSenderHelper {

	@Autowired
	private TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;

	@Autowired
	private UserIdMapper userIdMapper;

	@Autowired
	private MessageSenderRegistry messageSenderRegistry;


	public void send(UserId receiverId, UserId senderId, TransportMessage transportMessage) {
		// agree on transport protocol
		String transportProtocolId = transportProtocolDiscoveryStrategy.agreeOnTransportProtocol(receiverId);

		// set TIDs of sender and receiver
		transportMessage.setReceiverTid(userIdMapper.resolveRemote(receiverId, transportProtocolId));
		transportMessage.setSenderTid(userIdMapper.resolveLocal(senderId, transportProtocolId));

		// send mesg
		MessageSender messageSender = messageSenderRegistry.getMessageSender(transportProtocolId);
		messageSender.send(transportMessage);
	}
}
