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
package deus.common;

import org.easymock.classextension.EasyMock;

/**
 * This template provides support for using EasyMock for creating the
 * dependencies of the SUT and the test fixture. The dependencies are setup
 * using <code>EasyMock.createMock()</code> in the method
 * <code>setUpDependencies</code>. The test fixture is setup using
 * <code>EasyMock.createMock()</code> in the method
 * <code>setUpTestFixture</code>.
 * 
 * Teardown of all mocked dependencies as well as teardown of the test fixture
 * is automated.
 * 
 * The method <code>getDependencyMocks</code> must be implemented to return all
 * dependencies that are created by using mocks. The method
 * <code>getFixtureMocks</code> must be implemented to return all fixture
 * elements that are created by using mocks.
 * 
 * Furthermore, the method <code>replayAllMocks</code> replays all dependency
 * and fixture mocks. The method <code>verifyAllMocks</code> verifies all mocks
 * after a test run.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public abstract class DeusUnitTestCaseEasyMockTemplate extends
		DeusUnitTestCaseTemplate {

	/**
	 * Gets the dependency mocks.
	 * 
	 * @return the dependency mocks
	 */
	protected abstract Object[] getDependencyMocks();

	/**
	 * Gets the fixture mocks.
	 * 
	 * @return the fixture mocks
	 */
	protected abstract Object[] getFixtureMocks();

	/**
	 * Replay all mocks.
	 */
	protected final void replayAllMocks() {
		if (this.getDependencyMocks() != null) {
			EasyMock.replay(this.getDependencyMocks());
		}
		if (this.getFixtureMocks() != null) {
			EasyMock.replay(this.getFixtureMocks());
		}
	}

	/**
	 * Verify all mocks.
	 */
	protected final void verifyAllMocks() {
		if (this.getDependencyMocks() != null) {
			EasyMock.verify(this.getDependencyMocks());
		}
		if (this.getFixtureMocks() != null) {
			EasyMock.verify(this.getFixtureMocks());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#tearDownDependencies()
	 */
	@Override
	protected final void tearDownDependencies() {
		if (this.getDependencyMocks() != null) {
			EasyMock.reset(this.getDependencyMocks());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.common.DeusUnitTestCaseTemplate#tearDownFixture()
	 */
	@Override
	protected final void tearDownFixture() {
		if (this.getFixtureMocks() != null) {
			EasyMock.reset(this.getFixtureMocks());
		}
	}

}
