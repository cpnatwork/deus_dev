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
package deus.model.dccontent;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.dccontent.party.Party;

/**
 * The Class PartyInformationDC.
 */
public class PartyInformationDC extends DigitalCard {

	/** The party. */
	private Party party;
	
	/**
	 * Instantiates a new party information dc.
	 * 
	 * @param digitalCardId
	 *            the digital card id
	 */
	public PartyInformationDC(DigitalCardId digitalCardId) {
		super(digitalCardId);
	}

	/**
	 * Gets the party information.
	 * 
	 * @return the party information
	 */
	public Party getPartyInformation() {
		return party;
	}
	
	/**
	 * Sets the party information.
	 * 
	 * @param partyInformation
	 *            the new party information
	 */
	public void setPartyInformation(Party partyInformation) {
		if(!partyInformation.getId().equals(getDigitalCardId().getCpId()))
			throw new IllegalArgumentException("passed a party information with an ID not equal to the ID of the CP of this digital card!");
		party = partyInformation;
	}

}
