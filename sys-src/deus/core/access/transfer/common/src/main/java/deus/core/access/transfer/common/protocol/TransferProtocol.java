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
 * The Interface TransferProtocol.
 */
public interface TransferProtocol {

	/**
	 * Gets the message sender.
	 * 
	 * @return the message sender
	 */
	public abstract MessageSender getMessageSender();

	/**
	 * Gets the login event callback.
	 * 
	 * @return the login event callback
	 */
	public abstract LoginEventCallback getLoginEventCallback();

	/**
	 * Gets the registration event callback.
	 * 
	 * @return the registration event callback
	 */
	public abstract RegistrationEventCallback getRegistrationEventCallback();

	/**
	 * Gets the user id mapper.
	 * 
	 * @return the user id mapper
	 */
	public abstract UserIdMapper getUserIdMapper();

	/**
	 * Gets the protocol id.
	 * 
	 * @return the protocol id
	 */
	public abstract String getProtocolId();

}