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
package deus.model.attention;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.id.UserUrl;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.publication.connection.establish.pubinit.PublisherOffer;

/**
 * The Class PublisherOfferTest.
 */
public class PublisherOfferTest {

	/** The dec. */
	BinaryDecisionToMake dec;
	
	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		dec = new PublisherOffer(new PublisherId(new UserUrl("alice", "http://www.deus.org")), new UserMetadata());
	}


	/**
	 * Test set decision positive.
	 */
	@Test
	public void testSetDecisionPositive() {
		assertFalse(dec.isDecisionMade());
		dec.setDecisionPositive();
		assertTrue(dec.isDecisionMade());
		assertTrue(dec.isDecisionPositive());
		assertFalse(dec.isDecisionNegative());
	}

	
	/**
	 * Test set decision negative.
	 */
	@Test
	public void testSetDecisionNegative() {
		assertFalse(dec.isDecisionMade());
		dec.setDecisionNegative();
		assertTrue(dec.isDecisionMade());
		assertTrue(dec.isDecisionNegative());
		assertFalse(dec.isDecisionPositive());
	}
	
	
	/**
	 * Test exception.
	 */
	@Test
	public void testException() {
		assertFalse(dec.isDecisionMade());
		try {
			dec.isDecisionPositive();
			fail("exception not thrown");
		}
		catch(IllegalStateException e) {}
		try {
			dec.isDecisionNegative();
			fail("exception not thrown");
		}
		catch(IllegalStateException e) {}
	}
}
