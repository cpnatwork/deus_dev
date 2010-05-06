package deus.common;

import org.easymock.EasyMock;
import org.springframework.beans.factory.FactoryBean;

/**
 * This is needed for autowiring mocks, that are created by EasyMock. Spring uses the return type of factory methods for
 * autowiring the beans that are created by these methods. Since <code>Easymock.createMock(Class)</code> returns an
 * Object, Spring fails to autowire Mocks created by this method.
 * 
 * Thus, this class is used as a helper, since there is the method <code>getObjectType</code>, that explicitly specifies
 * the return type.
 * 
 * See more on this issue at http://javadevelopmentforthemasses.blogspot.com/2008/07/mocking-spring-tests.html.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 * @param <T>
 */
public class EasyMockFactoryBean<T> implements FactoryBean<T> {

	private Class<T> type;// the created object type


	public void setType(final Class<T> type) {
		this.type = type;
	}


	@Override
	public T getObject() throws Exception {
		return EasyMock.createMock(type);
	}


	@Override
	public Class<T> getObjectType() {
		return type;
	}


	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
