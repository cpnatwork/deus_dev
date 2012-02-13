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

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The Class AbstractSubsystemAssemblyTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/all.xml" })
public abstract class AbstractSubsystemAssemblyTest {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory.getLogger(AbstractSubsystemAssemblyTest.class);
	
	/** The context. */
	@Autowired
	private ApplicationContext context;

	/** The subsystem base package. */
	private String subsystemBasePackage;


	/**
	 * Instantiates a new abstract subsystem assembly test.
	 */
	public AbstractSubsystemAssemblyTest() {
		this.subsystemBasePackage = getClass().getPackage().getName().toString();
	}
	
	/**
	 * Instantiates a new abstract subsystem assembly test.
	 * 
	 * @param subsystemBasePackage
	 *            the subsystem base package
	 */
	public AbstractSubsystemAssemblyTest(String subsystemBasePackage) {
		this.subsystemBasePackage = subsystemBasePackage;
	}


	/**
	 * Test integration.
	 */
	@Test
	public void testIntegration() {
		logger.info("loaded Spring beans: " + Arrays.toString(context.getBeanDefinitionNames()));


		StringBuilder loadedDomainBeans = new StringBuilder();

		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			Object bean = context.getBean(name);
			if (bean.getClass().getPackage() != null
					&& bean.getClass().getPackage().getName().startsWith(subsystemBasePackage))
				loadedDomainBeans.append(name + ", ");
		}

		int l = loadedDomainBeans.length();
		if (l > 0)
			loadedDomainBeans.delete(l - 2, l);
		logger.info("loaded domain beans: [" + loadedDomainBeans.toString() + "]");
	}

}
