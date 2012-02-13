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
package deus.core.access.transfer.common.messages.publication;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.model.common.dossier.DigitalCard;

/**
 * Command, issued by the publisher to inform registered subscribers about an
 * update.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class UpdateMessage extends TransferMessage {

	/** The digital card. */
	private final DigitalCard digitalCard;

	/**
	 * Instantiates a new update message.
	 * 
	 * @param digitalCard
	 *            the digital card
	 */
	public UpdateMessage(final DigitalCard digitalCard) {
		super();
		this.digitalCard = digitalCard;
	}

	/**
	 * Gets the digital card.
	 * 
	 * @return the digital card
	 */
	public DigitalCard getDigitalCard() {
		return this.digitalCard;
	}

}
