package deus.core.soul.hci.barker;

import static org.junit.Assert.fail;

import org.easymock.classextension.EasyMock;
import org.junit.Test;

public class BarkerExportedToSubsystemsTest extends AbstractBarkerTest {

	@Test
	public void testAddUnnoticedAttentionElement_HappyPath() {
		attentionElementDaoMock.addNewEntity(userIdFix, attentionElementFix);
		replayAllMocks();

		barkerSUT.addUnnoticedAttentionElement(userIdFix, attentionElementFix);

		verifyAllMocks();
	}


	@Test
	public void testAddUnnoticedAttentionElement_AttentionElementAlreadyNoticed() {
		EasyMock.expect(attentionElementFix.isNoticed()).andReturn(true);
		replayAllMocks();

		try {
			barkerSUT.addUnnoticedAttentionElement(userIdFix, attentionElementFix);
			fail("attentionElement is already noticed!");
		}
		catch (BarkerRuntimeException e) {
			// expected
		}
	
		verifyAllMocks();
	}


}
