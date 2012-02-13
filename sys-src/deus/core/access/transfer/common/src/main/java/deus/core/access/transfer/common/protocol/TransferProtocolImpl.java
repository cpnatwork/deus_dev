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
package deus.core.access.transfer.common.protocol;

import deus.core.access.transfer.common.protocol.callback.LoginEventCallback;
import deus.core.access.transfer.common.protocol.callback.RegistrationEventCallback;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;

/**
 * The Class TransferProtocolImpl.
 */
public final class TransferProtocolImpl implements TransferProtocol {

	/** The protocol id. */
	private String protocolId;


	/** The message sender. */
	private MessageSender messageSender;

	/** The login event callback. */
	private LoginEventCallback loginEventCallback;

	/** The registration event callback. */
	private RegistrationEventCallback registrationEventCallback;

	/** The user id mapper. */
	private UserIdMapper userIdMapper;


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocol.TransferProtocol#getProtocolId()
	 */
	public String getProtocolId() {
		return protocolId;
	}


	/**
	 * Sets the protocol id.
	 * 
	 * @param protocolId
	 *            the new protocol id
	 */
	public void setProtocolId(String protocolId) {
		this.protocolId = protocolId;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocol.TransferProtocol#getMessageSender()
	 */
	@Override
	public MessageSender getMessageSender() {
		return messageSender;
	}


	/**
	 * Sets the message sender.
	 * 
	 * @param messageSender
	 *            the new message sender
	 */
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocol.TransferProtocol#getLoginEventCallback()
	 */
	@Override
	public LoginEventCallback getLoginEventCallback() {
		return loginEventCallback;
	}


	/**
	 * Sets the login event callback.
	 * 
	 * @param loginEventCallback
	 *            the new login event callback
	 */
	public void setLoginEventCallback(LoginEventCallback loginEventCallback) {
		this.loginEventCallback = loginEventCallback;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocol.TransferProtocol#getRegistrationEventCallback()
	 */
	@Override
	public RegistrationEventCallback getRegistrationEventCallback() {
		return registrationEventCallback;
	}


	/**
	 * Sets the registration event callback.
	 * 
	 * @param registrationEventCallback
	 *            the new registration event callback
	 */
	public void setRegistrationEventCallback(RegistrationEventCallback registrationEventCallback) {
		this.registrationEventCallback = registrationEventCallback;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocol.TransferProtocol#getUserIdMapper()
	 */
	@Override
	public UserIdMapper getUserIdMapper() {
		return userIdMapper;
	}


	/**
	 * Sets the user id mapper.
	 * 
	 * @param userIdMapper
	 *            the new user id mapper
	 */
	public void setUserIdMapper(UserIdMapper userIdMapper) {
		this.userIdMapper = userIdMapper;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getProtocolId();
	}

}
