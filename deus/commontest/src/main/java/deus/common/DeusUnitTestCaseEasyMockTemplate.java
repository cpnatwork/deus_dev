package deus.common;

import org.easymock.classextension.EasyMock;

/**
 * This template provides support for using EasyMock for creating the dependencies of the SUT and the test fixture. The
 * dependencies are setup using <code>EasyMock.createMock()</code> in the method <code>setUpDependencies</code>. The
 * test fixture is setup using <code>EasyMock.createMock()</code> in the method <code>setUpTestFixture</code>.
 * 
 * Teardown of all mocked dependencies as well as teardown of the test fixture is automated.
 * 
 * The method <code>getDependencyMocks</code> must be implemented to return all dependencies that are created by using
 * mocks. The method <code>getFixtureMocks</code> must be implemented to return all fixture elements that are created by
 * using mocks.
 * 
 * Furthermore, the method <code>replayAllMocks</code> replays all dependency and fixture mocks. The method
 * <code>verifyAllMocks</code> verifies all mocks after a test run.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public abstract class DeusUnitTestCaseEasyMockTemplate extends DeusUnitTestCaseTemplate {

	protected abstract Object[] getDependencyMocks();

	protected abstract Object[] getFixtureMocks();


	protected final void replayAllMocks() {
		if(getDependencyMocks() != null)
			EasyMock.replay(getDependencyMocks());
		if(getFixtureMocks() != null)
			EasyMock.replay(getFixtureMocks());
	}


	protected final void verifyAllMocks() {
		if(getDependencyMocks() != null)
			EasyMock.verify(getDependencyMocks());
		if(getFixtureMocks() != null)
			EasyMock.verify(getFixtureMocks());
	}


	@Override
	protected final void tearDownDependencies() {
		if(getDependencyMocks() != null)
			EasyMock.reset(getDependencyMocks());
	}


	@Override
	protected final void tearDownFixture() {
		if(getFixtureMocks() != null)
			EasyMock.reset(getFixtureMocks());
	}

}
