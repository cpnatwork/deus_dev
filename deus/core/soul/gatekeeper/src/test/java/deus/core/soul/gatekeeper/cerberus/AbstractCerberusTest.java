package deus.core.soul.gatekeeper.cerberus;

import static org.junit.Assert.assertEquals;

import org.easymock.classextension.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import deus.common.DeusUnitTestCaseEasyMockTemplate;
import deus.core.access.storage.api.common.account.AccountDao;
import deus.core.soul.gatekeeper.cerberus.LoginCredentialChecker;
import deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver;
import deus.core.soul.gatekeeper.cerberus.impl.Cerberus;
import deus.core.soul.gatekeeper.cerberus.impl.CerberusImpl;
import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;

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
