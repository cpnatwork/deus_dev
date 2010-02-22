package deus.core.soul.gatekeeper.cerberus;

import org.easymock.classextension.EasyMock;
import org.springframework.test.util.ReflectionTestUtils;

import deus.common.DeusUnitTestCaseEasyMockTemplate;
import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.soul.gatekeeper.cerberus.impl.Cerberus;
import deus.core.soul.gatekeeper.cerberus.impl.CerberusImpl;

public abstract class AbstractCerberusTest extends DeusUnitTestCaseEasyMockTemplate {

	protected LoginCredentialChecker loginCredentialCheckerMock;
	protected AccountDao accountDaoMock;

	
	@Override
	protected Object[] getDependencyMocks() {
		return new Object[] {loginCredentialCheckerMock, accountDaoMock};
	}


	@Override
	protected void setUpDependencies() {
		loginCredentialCheckerMock = EasyMock.createMock(LoginCredentialChecker.class);
		accountDaoMock = EasyMock.createMock(AccountDao.class);
	}

	
	protected Cerberus cerberus;

	@Override
	protected void setUpSUT() {
		cerberus = new CerberusImpl();
		ReflectionTestUtils.setField(cerberus, "accountDao", accountDaoMock);
		ReflectionTestUtils.setField(cerberus, "loginCredentialChecker", loginCredentialCheckerMock);
	}


	@Override
	protected void tearDownSUT() {
		cerberus = null;
	}

}
