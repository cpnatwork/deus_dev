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
import org.springframework.test.util.ReflectionTestUtils;

import deus.common.DeusUnitTestCaseEasyMockTemplate;
import deus.core.access.storage.api.hci.attention.AttentionElementDao;
import deus.core.access.storage.api.hci.attention.AttentionListDao;
import deus.core.soul.hci.barker.impl.Barker;
import deus.core.soul.hci.barker.impl.BarkerImpl;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;

/**
 * The Class AbstractBarkerTest.
 */
public abstract class AbstractBarkerTest extends
		DeusUnitTestCaseEasyMockTemplate {

	/** The user id fix. */
	protected UserId userIdFix;

	/** The attention element fix. */
	protected AttentionElement attentionElementFix;

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpFixture()
	 */
	@Override
	protected final void setUpFixture() {
		this.userIdFix = EasyMock.createMock(UserId.class);
		this.attentionElementFix = EasyMock
				.createNiceMock(AttentionElement.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseEasyMockTemplate#getFixtureMocks()
	 */
	@Override
	protected final Object[] getFixtureMocks() {
		final Object[] fix = { this.userIdFix, this.attentionElementFix };
		return fix;
	}

	/** The attention element dao mock. */
	protected AttentionElementDao attentionElementDaoMock;

	/** The attention list dao mock. */
	protected AttentionListDao attentionListDaoMock;

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpDependencies()
	 */
	@Override
	protected final void setUpDependencies() {
		this.attentionElementDaoMock = EasyMock
				.createMock(AttentionElementDao.class);
		this.attentionListDaoMock = EasyMock.createMock(AttentionListDao.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseEasyMockTemplate#getDependencyMocks()
	 */
	@Override
	protected final Object[] getDependencyMocks() {
		final Object[] deps = { this.attentionElementDaoMock,
				this.attentionListDaoMock };
		return deps;
	}

	/** The barker sut. */
	protected Barker barkerSUT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#setUpSUT()
	 */
	@Override
	protected final void setUpSUT() {
		this.barkerSUT = new BarkerImpl();
		ReflectionTestUtils.setField(this.barkerSUT, "attentionElementDao",
				this.attentionElementDaoMock);
		ReflectionTestUtils.setField(this.barkerSUT, "attentionListDao",
				this.attentionListDaoMock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#tearDownSUT()
	 */
	@Override
	protected final void tearDownSUT() {
		this.barkerSUT = null;
	}

}