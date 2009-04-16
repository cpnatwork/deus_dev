package deus.core.soul.hci.barker;


import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.createNiceMock;

import org.easymock.classextension.EasyMock;
import org.springframework.test.util.ReflectionTestUtils;

import deus.common.DeusUnitTestCaseEasyMockTemplate;
import deus.core.access.storage.api.hci.attention.AttentionElementDao;
import deus.core.access.storage.api.hci.attention.AttentionListDao;
import deus.core.soul.hci.barker.impl.Barker;
import deus.core.soul.hci.barker.impl.BarkerImpl;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;

public abstract class AbstractBarkerTest extends DeusUnitTestCaseEasyMockTemplate {

	protected UserId userIdFix;
	protected AttentionElement attentionElementFix;


	@Override
	protected final void setUpFixture() {
		userIdFix = createMock(UserId.class);
		attentionElementFix = createNiceMock(AttentionElement.class);
	}


	@Override
	protected final Object[] getFixtureMocks() {
		Object[] fix = { userIdFix, attentionElementFix };
		return fix;
	}


	protected AttentionElementDao attentionElementDaoMock;
	protected AttentionListDao attentionListDaoMock;


	@Override
	protected final void setUpDependencies() {
		attentionElementDaoMock = EasyMock.createMock(AttentionElementDao.class);
		attentionListDaoMock = EasyMock.createMock(AttentionListDao.class);
	}


	@Override
	protected final Object[] getDependencyMocks() {
		Object[] deps = { attentionElementDaoMock, attentionListDaoMock };
		return deps;
	}


	protected Barker barkerSUT;


	@Override
	protected final void setUpSUT() {
		barkerSUT = new BarkerImpl();
		ReflectionTestUtils.setField(barkerSUT, "attentionElementDao", attentionElementDaoMock);
		ReflectionTestUtils.setField(barkerSUT, "attentionListDao", attentionListDaoMock);
	}


	@Override
	protected final void tearDownSUT() {
		barkerSUT = null;
	}


}