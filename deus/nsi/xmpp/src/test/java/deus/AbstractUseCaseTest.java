package deus;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import deus.core.User;

public abstract class AbstractUseCaseTest {

	protected void testAttentionList(User user, int unnoticedElements, int noticedElements) {
		assertEquals("Number of unnoticed attention elements in " + user.getUserMetadata().getUserId()
				+ "'s attentionList is wrong!", unnoticedElements, user.getBarker().getUnnoticedAttentionList().size());
		assertEquals("Number of noticed attention elements in " + user.getUserMetadata().getUserId()
				+ "'s attentionList is wrong!", noticedElements, user.getBarker().getNoticedAttentionList().size());
	}



	protected void testDateNow(Date date) {
		assertEquals((new Date()).getTime(), date.getTime(), 2000);
	}
}
