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

import org.junit.After;
import org.junit.Before;

/**
 * This is a template for unit testing DEUS classes.
 * 
 * A single system is tested, being called "System Under Test" (SUT). This system has dependencies that are provided by
 * Mock objects, using EasyMock. Other objects being needed for testing are included in the "test fixture".
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public abstract class DeusUnitTestCaseTemplate {

	/**
	 * Sets up all dependencies of the SUT. Only the setup of the dependencies is done here. Injection of them into the
	 * SUT is done in <code>setUpSUT</code>.
	 * 
	 * Therefore, EasyMock may be used, instrumenting the static method <code>EasyMock.createMock()</code>.
	 * 
	 * This method is called prior to every single test annotated with <code>@Test</code>.
	 */
	protected abstract void setUpDependencies();


	/**
	 * The SUT is set up in this method. All dependencies that are created by <code>setUpMocks</code> are injected into
	 * the SUT in this method.
	 * 
	 * Private fields of the SUT that are autowired by Spring using <code>@Autowired</code> can be set using
	 * <code>org.springframework.test.util.ReflectionTestUtils</code> from Spring Test Framework.
	 * 
	 * This method is called prior to every single test annotated with <code>@Test</code>.
	 */
	protected abstract void setUpSUT();


	/**
	 * Any domain objects or other objects that are not dependencies of the SUT, but needed for testing, are set up in
	 * this method. This can also done by using EasyMock (<code>EasyMock.createMock()</code>, or
	 * <code>EasyMock.createNiceMock()</code>.
	 * 
	 * This method is called prior to every single test annotated with <code>@Test</code>.
	 */
	protected abstract void setUpFixture();


	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public final void setUp() throws Exception {
		setUpDependencies();

		setUpSUT();

		setUpFixture();
	}


	/**
	 * All dependencies of the SUT are torn down here. This can be done using the static method
	 * <code>EasyMock.reset()</code>.
	 * 
	 * This method is called prior to every single test annotated with <code>@Test</code>.
	 */
	protected abstract void tearDownDependencies();


	/**
	 * The SUT is torn down in this method.
	 * 
	 * This method is called prior to every single test annotated with <code>@Test</code>.
	 */
	protected abstract void tearDownSUT();


	/**
	 * All methods of the text fixture are torn down here. If they were created using EasyMock, the static method
	 * <code>EasyMock.reset()</code> can be used.
	 * 
	 * This method is called prior to every single test annotated with <code>@Test</code>.
	 */
	protected abstract void tearDownFixture();


	/**
	 * Tear down.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@After
	public final void tearDown() throws Exception {
		tearDownDependencies();

		tearDownSUT();

		tearDownFixture();
	}

}
