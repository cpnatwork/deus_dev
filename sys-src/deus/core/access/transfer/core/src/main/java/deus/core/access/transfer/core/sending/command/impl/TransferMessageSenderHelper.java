package deus.core.access.transfer.core.sending.command.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;
import deus.core.access.transfer.core.sending.message.MessageSenderRegistry;
import deus.core.access.transfer.core.soul.discovery.TransferProtocolNegotiationStrategy;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;
import deus.model.common.user.id.UserId;

@Named
public class TransferMessageSenderHelper {

	@Inject
	private TransferProtocolNegotiationStrategy transferProtocolNegotiationStrategy;

	@Inject
	private QueriableTransferProtocolRegistry transferProtocolRegistry;

	@Inject
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
