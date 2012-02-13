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

import deus.model.dccontent.party.Email;
import deus.model.dccontent.party.ImAccount;
import deus.model.dccontent.party.Occupation;
import deus.model.dccontent.party.Phone;
import deus.model.dccontent.party.RelatedPerson;
import deus.model.dccontent.party.WebPresence;

/**
 * The Class Person.
 */
public class Person extends deus.model.dccontent.party.Person {

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.dccontent.party.Person#getPhones()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Phone> getPhones() {
		return (List<Phone>) this.phones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.dccontent.party.Person#getEmails()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Email> getEmails() {
		return (List<Email>) this.emails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.dccontent.party.Person#getWebPresences()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<WebPresence> getWebPresences() {
		return (List<WebPresence>) this.webPresences;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.dccontent.party.Person#getImAccounts()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ImAccount> getImAccounts() {
		return (List<ImAccount>) this.imAccounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.dccontent.party.Person#getAddresses()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<AddressPO> getAddresses() {
		return (List<AddressPO>) this.addresses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.dccontent.party.Person#getOccupations()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Occupation> getOccupations() {
		return (List<Occupation>) this.occupations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.dccontent.party.Person#getRelatedPersons()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<RelatedPerson> getRelatedPersons() {
		return (List<RelatedPerson>) this.relatedPersons;
	}

}
