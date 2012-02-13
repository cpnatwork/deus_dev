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

import org.easymock.classextension.EasyMock;
import org.junit.Assert;
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
		this.attentionElementFix.setNoticed(true);
		this.attentionElementDaoMock.updateEntity(this.userIdFix,
				this.attentionElementFix);
		this.replayAllMocks();

		this.barkerSUT.noticeAttentionElement(this.userIdFix,
				this.attentionElementFix);

		this.verifyAllMocks();
	}

	/**
	 * Test notice attention element_ attention element already noticed.
	 */
	@Test
	public void testNoticeAttentionElement_AttentionElementAlreadyNoticed() {
		EasyMock.expect(this.attentionElementFix.isNoticed()).andReturn(true);
		this.replayAllMocks();

		try {
			this.barkerSUT.noticeAttentionElement(this.userIdFix,
					this.attentionElementFix);
			Assert.fail("attention element already noticed");
		} catch (final BarkerRuntimeException e) {
			// expected
		}

		this.verifyAllMocks();
	}

	/**
	 * Test get unnoticed attention list.
	 */
	@Test
	public void testGetUnnoticedAttentionList() {
		final AttentionList expectedRetVal = null;
		EasyMock.expect(
				this.attentionListDaoMock
						.getUnnoticedAttentionList(this.userIdFix)).andReturn(
				expectedRetVal);
		this.replayAllMocks();

		final AttentionList sutRetVal = this.barkerSUT
				.getUnnoticedAttentionList(this.userIdFix);
		Assert.assertEquals(expectedRetVal, sutRetVal);

		this.verifyAllMocks();
	}

	/**
	 * Test get noticed attention list.
	 */
	@Test
	public void testGetNoticedAttentionList() {
		final AttentionList expectedRetVal = EasyMock
				.createNiceMock(AttentionList.class);

		EasyMock.expect(
				this.attentionListDaoMock
						.getNoticedAttentionList(this.userIdFix)).andReturn(
				expectedRetVal);
		this.replayAllMocks();

		final AttentionList sutRetVal = this.barkerSUT
				.getNoticedAttentionList(this.userIdFix);
		Assert.assertEquals(expectedRetVal, sutRetVal);

		this.verifyAllMocks();
	}

}
