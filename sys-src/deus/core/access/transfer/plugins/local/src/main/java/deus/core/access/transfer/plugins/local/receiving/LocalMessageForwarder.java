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
package deus.core.access.transfer.plugins.local.receiving;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.messagereceiver.MessageReceiver;

/**
 * The Class LocalMessageForwarder.
 */
@Named
public class LocalMessageForwarder {

	/** The message receiver. */
	@Inject
	private MessageReceiver messageReceiver;

	/**
	 * Forward.
	 * 
	 * @param transferMessage
	 *            the transfer message
	 */
	public void forward(final TransferMessage transferMessage) {
		this.messageReceiver.receive(transferMessage);
	}

}
