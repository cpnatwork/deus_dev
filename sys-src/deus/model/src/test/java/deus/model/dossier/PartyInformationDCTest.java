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
package deus.model.dossier;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.id.UserUrl;
import deus.model.dccontent.PartyInformationDC;
import deus.model.dccontent.party.Person;

/**
 * The Class PartyInformationDCTest.
 */
public class PartyInformationDCTest {

	/** The dc. */
	private PartyInformationDC dc;

	/** The person. */
	private Person person;

	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.dc = new PartyInformationDC(new DigitalCardId(new UserUrl(
				"higgins", "http://www.deus.org"), new UserUrl("alice",
				"http://www.deus.org"),
				"party information from Higgins about Alice"));

		this.person = new Person();
		this.person.setId(new UserUrl("alice", "http://www.deus.org"));
		this.dc.setPartyInformation(this.person);
	}

	/**
	 * Test get party information.
	 */
	@Test
	public void testGetPartyInformation() {
		Assert.assertEquals(this.person, this.dc.getPartyInformation());
	}

	/**
	 * Test set party information.
	 */
	@Test
	public void testSetPartyInformation() {
		try {
			final Person otherPerson = new Person();
			otherPerson.setId(new UserUrl("another alice",
					"http://www.deus.org"));
			this.dc.setPartyInformation(otherPerson);
			Assert.fail("could set party information with different ID than the one of the digital card");
		} catch (final IllegalArgumentException e) {
		}
	}

}
