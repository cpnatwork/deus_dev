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
package deus.core.access.storage.api.archive.party;

import java.util.List;
import java.util.UUID;

import deus.model.common.user.id.UserId;
import deus.model.dccontent.party.Address;
import deus.model.dccontent.party.Email;
import deus.model.dccontent.party.ImAccount;
import deus.model.dccontent.party.Occupation;
import deus.model.dccontent.party.Phone;
import deus.model.dccontent.party.RelatedPerson;
import deus.model.dccontent.party.WebPresence;

// FIXME: REMOVE HIBERNATE STUFF FROM THIS CLASS
//@Entity
/**
 * The Class PersonTO.
 */
public class PersonTO extends deus.model.dccontent.party.Person {

	/** The uuid. */
	private UUID uuid;

//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	/**
 * Gets the uuid.
 * 
 * @return the uuid
 */
public UUID getUuid() {
		return uuid;
	}
		
	/**
	 * Sets the uuid.
	 * 
	 * @param uuid
	 *            the new uuid
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
//	@NaturalId
	/* (non-Javadoc)
 * @see deus.model.dccontent.party.Party#getId()
 */
public UserId getId() {
		return id;
	}


	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Party#setId(deus.model.common.user.id.UserId)
	 */
	public void setId(UserId id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Person#getPhones()
	 */
	@SuppressWarnings("unchecked")
	public List<Phone> getPhones() {
		return (List<Phone>) phones;
	}

	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Person#getEmails()
	 */
	@SuppressWarnings("unchecked")
	public List<Email> getEmails() {
		return (List<Email>) emails;
	}

	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Person#getWebPresences()
	 */
	@SuppressWarnings("unchecked")
	public List<WebPresence> getWebPresences() {
		return (List<WebPresence>) webPresences;
	}

	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Person#getImAccounts()
	 */
	@SuppressWarnings("unchecked")
	public List<ImAccount> getImAccounts() {
		return (List<ImAccount>) imAccounts;
	}

	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Person#getAddresses()
	 */
	@SuppressWarnings("unchecked")
	public List<Address> getAddresses() {
		return (List<Address>) addresses;
	}

	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Person#getOccupations()
	 */
	@SuppressWarnings("unchecked")
	public List<Occupation> getOccupations() {
		return (List<Occupation>) occupations;
	}

	/* (non-Javadoc)
	 * @see deus.model.dccontent.party.Person#getRelatedPersons()
	 */
	@SuppressWarnings("unchecked")
	public List<RelatedPerson> getRelatedPersons() {
		return (List<RelatedPerson>) relatedPersons;
	}

}
