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

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.classextension.EasyMock;
import org.junit.Test;

import deus.model.hci.attention.AttentionList;

/**
 * The Class BarkerExportedToClientTest.
 */
public class BarkerExportedToClientTest extends AbstractBarkerTest {

	/**
	 * Test notice attention element_ happy path.
	 */
	@Test
	public void testNoticeAttentionElement_HappyPath() {
		attentionElementFix.setNoticed(true);
		attentionElementDaoMock.updateEntity(userIdFix, attentionElementFix);
		replayAllMocks();

		barkerSUT.noticeAttentionElement(userIdFix, attentionElementFix);

		verifyAllMocks();
	}


	/**
	 * Test notice attention element_ attention element already noticed.
	 */
	@Test
	public void testNoticeAttentionElement_AttentionElementAlreadyNoticed() {
		expect(attentionElementFix.isNoticed()).andReturn(true);
		replayAllMocks();

		try {
			barkerSUT.noticeAttentionElement(userIdFix, attentionElementFix);
			fail("attention element already noticed");
		}
		catch (BarkerRuntimeException e) {
			// expected
		}

		verifyAllMocks();
	}


	/**
	 * Test get unnoticed attention list.
	 */
	@Test
	public void testGetUnnoticedAttentionList() {
		AttentionList expectedRetVal = null;
		expect(attentionListDaoMock.getUnnoticedAttentionList(userIdFix)).andReturn(expectedRetVal);
		replayAllMocks();

		AttentionList sutRetVal = barkerSUT.getUnnoticedAttentionList(userIdFix);
		assertEquals(expectedRetVal, sutRetVal);

		verifyAllMocks();
	}


	/**
	 * Test get noticed attention list.
	 */
	@Test
	public void testGetNoticedAttentionList() {
		AttentionList expectedRetVal = EasyMock.createNiceMock(AttentionList.class);

		expect(attentionListDaoMock.getNoticedAttentionList(userIdFix)).andReturn(expectedRetVal);
		replayAllMocks();

		AttentionList sutRetVal = barkerSUT.getNoticedAttentionList(userIdFix);
		assertEquals(expectedRetVal, sutRetVal);

		verifyAllMocks();
	}


}
