package deus.core.soul.hci.barker;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.createNiceMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.classextension.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.storage.api.hci.attention.AttentionElementDao;
import deus.core.access.storage.api.hci.attention.AttentionListDao;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;
import deus.model.hci.attention.AttentionList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/all.xml" })
@Deprecated
public class OldBarkerExportedToClientTest {

	@Autowired
	private BarkerExportedToClient barkerSUT;

	@Autowired
	private AttentionElementDao attentionElementDaoMock;

	@Autowired
	private AttentionListDao attentionListDaoMock;


	private UserId userIdFix;
	private AttentionElement attentionElementFix;


	@Before
	public void setUp() throws Exception {
		userIdFix = createMock(UserId.class);
		attentionElementFix = createNiceMock(AttentionElement.class);
	}


	@After
	public void tearDown() throws Exception {
		org.easymock.EasyMock.reset(attentionElementDaoMock, attentionListDaoMock);
	}


	@Test
	public void testNoticeAttentionElement_HappyPath() {
		attentionElementFix.setNoticed(true);
		replay(attentionElementFix);

		attentionElementDaoMock.updateEntity(userIdFix, attentionElementFix);
		replay(attentionElementDaoMock);

		barkerSUT.noticeAttentionElement(userIdFix, attentionElementFix);

		verify(attentionElementFix);
		verify(attentionElementDaoMock);
	}


	@Test
	public void testNoticeAttentionElement_AeAlreadyNoticed() {
		expect(attentionElementFix.isNoticed()).andReturn(true);
		replay(attentionElementFix);

		try {
			barkerSUT.noticeAttentionElement(userIdFix, attentionElementFix);
			fail();
		}
		catch (BarkerRuntimeException e) {
			// expected
		}

		verify(attentionElementFix);
	}


	@Test
	public void testGetUnnoticedAttentionList() {
		AttentionList expectedRetVal = null;

		expect(attentionListDaoMock.getUnnoticedAttentionList(userIdFix)).andReturn(expectedRetVal);
		replay(attentionListDaoMock);

		AttentionList sutRetVal = barkerSUT.getUnnoticedAttentionList(userIdFix);
		assertEquals(expectedRetVal, sutRetVal);

		verify(attentionListDaoMock);
	}


	@Test
	public void testGetNoticedAttentionList() {
		AttentionList expectedRetVal = EasyMock.createNiceMock(AttentionList.class);

		expect(attentionListDaoMock.getNoticedAttentionList(userIdFix)).andReturn(expectedRetVal);
		replay(attentionListDaoMock);

		AttentionList sutRetVal = barkerSUT.getNoticedAttentionList(userIdFix);
		assertEquals(expectedRetVal, sutRetVal);

		verify(attentionListDaoMock);
	}

}
