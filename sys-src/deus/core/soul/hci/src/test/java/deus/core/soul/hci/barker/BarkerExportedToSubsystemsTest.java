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
package deus.core.soul.hci.barker;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class BarkerExportedToSubsystemsTest.
 */
public class BarkerExportedToSubsystemsTest extends AbstractBarkerTest {

	/**
	 * Test add unnoticed attention element_ happy path.
	 */
	@Test
	public void testAddUnnoticedAttentionElement_HappyPath() {
		this.attentionElementDaoMock.addNewEntity(this.userIdFix,
				this.attentionElementFix);
		this.replayAllMocks();

		this.barkerSUT.addUnnoticedAttentionElement(this.userIdFix,
				this.attentionElementFix);

		this.verifyAllMocks();
	}

	/**
	 * Test add unnoticed attention element_ attention element already noticed.
	 */
	@Test
	public void testAddUnnoticedAttentionElement_AttentionElementAlreadyNoticed() {
		org.easymock.EasyMock.expect(this.attentionElementFix.isNoticed())
				.andReturn(true);
		this.replayAllMocks();

		try {
			this.barkerSUT.addUnnoticedAttentionElement(this.userIdFix,
					this.attentionElementFix);
			Assert.fail("attentionElement is already noticed!");
		} catch (final BarkerRuntimeException e) {
			// expected
		}

		this.verifyAllMocks();
	}

}
