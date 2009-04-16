package deus.common;

import org.easymock.classextension.EasyMock;

public abstract class DeusUnitTestCaseEasyMockTemplate extends DeusUnitTestCaseTemplate {

	protected abstract Object[] getDependencyMocks();
	
	protected abstract Object[] getFixtureMocks();

	protected final void replayAllMocks() {
		EasyMock.replay(getDependencyMocks());
		EasyMock.replay(getFixtureMocks());
	}
	
	protected final void verifyAllMocks() {
		EasyMock.verify(getDependencyMocks());
		EasyMock.verify(getFixtureMocks());
	}
	
	@Override
	protected final void tearDownDependencies() {
		EasyMock.reset(getDependencyMocks());
	}


	@Override
	protected final void tearDownFixture() {
		EasyMock.reset(getFixtureMocks());
	}

}
