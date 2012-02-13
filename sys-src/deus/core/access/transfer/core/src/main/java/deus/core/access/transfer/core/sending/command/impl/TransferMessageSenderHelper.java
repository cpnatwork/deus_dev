/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
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

/**
 * The Class TransferMessageSenderHelper.
 */
@Named
public class TransferMessageSenderHelper {

	/** The transfer protocol negotiation strategy. */
	@Inject
	private TransferProtocolNegotiationStrategy transferProtocolNegotiationStrategy;

	/** The transfer protocol registry. */
	@Inject
	private QueriableTransferProtocolRegistry transferProtocolRegistry;

	/** The message sender registry. */
	@Inject
	private MessageSenderRegistry messageSenderRegistry;


	/**
	 * Send.
	 * 
	 * @param receiverId
	 *            the receiver id
	 * @param senderId
	 *            the sender id
	 * @param transferMessage
	 *            the transfer message
	 */
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
