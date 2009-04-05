package deus.core.access.transfer.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;
import deus.core.access.transfer.core.sending.message.MessageSenderRegistry;
import deus.core.access.transfer.core.soul.discovery.TransferProtocolNegotiationStrategy;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;
import deus.model.user.id.UserId;

@Component
public class TransferMessageSenderHelper {

	@Autowired
	private TransferProtocolNegotiationStrategy transferProtocolNegotiationStrategy;

	@Autowired
	private QueriableTransferProtocolRegistry transferProtocolRegistry;

	@Autowired
	private MessageSenderRegistry messageSenderRegistry;


	public void send(UserId receiverId, UserId senderId, TransferMessage transferMessage) {
		// agree on transfer protocol
		String transferProtocolId = transferProtocolNegotiationStrategy.negotiateTransferProtocol(receiverId);

		UserIdMapper userIdMapper = transferProtocolRegistry.getRegisteredTransferProtocol(transferProtocolId).getUserIdMapper();
		
		// set IDs of sender and receiver
		transferMessage.setSenderId(senderId);
		transferMessage.setReceiverId(receiverId);
		
		// set TIDs of sender and receiver
		transferMessage.setReceiverTid(userIdMapper.resolveRemote(receiverId));
		transferMessage.setSenderTid(userIdMapper.resolveLocal(senderId));

		// send msg
		MessageSender messageSender = messageSenderRegistry.getMessageSender(transferProtocolId);
		messageSender.send(transferMessage);
	}
}
