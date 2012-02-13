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
package deus.core.access.transfer.common.messages;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.model.common.user.id.UserId;

/**
 * The Class TransferMessage.
 */
public abstract class TransferMessage {

	/** The sender id. */
	private UserId senderId;

	/** The receiver id. */
	private UserId receiverId;

	/** The sender tid. */
	private TransferId senderTid;

	/** The receiver tid. */
	private TransferId receiverTid;

	/**
	 * Instantiates a new transfer message.
	 */
	public TransferMessage() {
		super();
	}

	/**
	 * Gets the sender id.
	 * 
	 * @return the sender id
	 */
	public UserId getSenderId() {
		return this.senderId;
	}

	/**
	 * Sets the sender id.
	 * 
	 * @param senderId
	 *            the new sender id
	 */
	public void setSenderId(final UserId senderId) {
		this.senderId = senderId;
	}

	/**
	 * Gets the receiver id.
	 * 
	 * @return the receiver id
	 */
	public UserId getReceiverId() {
		return this.receiverId;
	}

	/**
	 * Sets the receiver id.
	 * 
	 * @param receiverId
	 *            the new receiver id
	 */
	public void setReceiverId(final UserId receiverId) {
		this.receiverId = receiverId;
	}

	/**
	 * Gets the sender tid.
	 * 
	 * @return the sender tid
	 */
	public TransferId getSenderTid() {
		return this.senderTid;
	}

	/**
	 * Sets the sender tid.
	 * 
	 * @param senderTid
	 *            the new sender tid
	 */
	public void setSenderTid(final TransferId senderTid) {
		this.senderTid = senderTid;
	}

	/**
	 * Gets the receiver tid.
	 * 
	 * @return the receiver tid
	 */
	public TransferId getReceiverTid() {
		return this.receiverTid;
	}

	/**
	 * Sets the receiver tid.
	 * 
	 * @param receiverTid
	 *            the new receiver tid
	 */
	public void setReceiverTid(final TransferId receiverTid) {
		this.receiverTid = receiverTid;
	}

}
