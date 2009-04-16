package deus.core.soul.hci.barker;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.classextension.EasyMock;
import org.junit.Test;

import deus.model.hci.attention.AttentionList;

public class BarkerExportedToClientTest extends AbstractBarkerTest {

	@Test
	public void testNoticeAttentionElement_HappyPath() {
		attentionElementFix.setNoticed(true);
		attentionElementDaoMock.updateEntity(userIdFix, attentionElementFix);
		replayAllMocks();

		barkerSUT.noticeAttentionElement(userIdFix, attentionElementFix);

		verifyAllMocks();
	}


	@Test
	public void testNoticeAttentionElement_AttentionElementAlreadyNoticed() {
		expect(attentionElementFix.isNoticed()).andReturn(true);
		replayAllMocks();

		try {
			barkerSUT.noticeAttentionElement(userIdFix, attentionElementFix);
			fail("attention element already noticed");
		}
		catch (BarkerRuntimeException e) {
			// expected
		}

		verifyAllMocks();
	}


	@Test
	public void testGetUnnoticedAttentionList() {
		AttentionList expectedRetVal = null;
		expect(attentionListDaoMock.getUnnoticedAttentionList(userIdFix)).andReturn(expectedRetVal);
		replayAllMocks();

		AttentionList sutRetVal = barkerSUT.getUnnoticedAttentionList(userIdFix);
		assertEquals(expectedRetVal, sutRetVal);

		verifyAllMocks();
	}


	@Test
	public void testGetNoticedAttentionList() {
		AttentionList expectedRetVal = EasyMock.createNiceMock(AttentionList.class);

		expect(attentionListDaoMock.getNoticedAttentionList(userIdFix)).andReturn(expectedRetVal);
		replayAllMocks();

		AttentionList sutRetVal = barkerSUT.getNoticedAttentionList(userIdFix);
		assertEquals(expectedRetVal, sutRetVal);

		verifyAllMocks();
	}


}
