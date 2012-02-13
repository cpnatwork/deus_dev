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

import org.easymock.EasyMock;
import org.springframework.beans.factory.FactoryBean;

/**
 * This is needed for autowiring mocks, that are created by EasyMock. Spring
 * uses the return type of factory methods for autowiring the beans that are
 * created by these methods. Since <code>Easymock.createMock(Class)</code>
 * returns an Object, Spring fails to autowire Mocks created by this method.
 * 
 * Thus, this class is used as a helper, since there is the method
 * <code>getObjectType</code>, that explicitly specifies the return type.
 * 
 * See more on this issue at
 * http://javadevelopmentforthemasses.blogspot.com/2008
 * /07/mocking-spring-tests.html.
 * 
 * @param <T>
 *            the generic type
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public class EasyMockFactoryBean<T> implements FactoryBean<T> {

	/** The type. */
	private Class<T> type;// the created object type

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(final Class<T> type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public T getObject() throws Exception {
		return EasyMock.createMock(this.type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<T> getObjectType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
