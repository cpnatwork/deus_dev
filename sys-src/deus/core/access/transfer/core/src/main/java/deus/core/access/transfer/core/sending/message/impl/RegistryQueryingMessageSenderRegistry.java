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
package deus.core.access.transfer.core.sending.message.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.protocol.messagesender.MessageSender;
import deus.core.access.transfer.core.sending.message.MessageSenderRegistry;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;

/**
 * The Class RegistryQueryingMessageSenderRegistry.
 */
@Named
public class RegistryQueryingMessageSenderRegistry implements
		MessageSenderRegistry {

	/** The registry. */
	@Inject
	private QueriableTransferProtocolRegistry registry;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.transfer.core.sending.message.MessageSenderRegistry#
	 * getMessageSender(java.lang.String)
	 */
	@Override
	public MessageSender getMessageSender(final String transferProtocolId) {
		return this.registry.getRegisteredTransferProtocol(transferProtocolId)
				.getMessageSender();
	}

}
