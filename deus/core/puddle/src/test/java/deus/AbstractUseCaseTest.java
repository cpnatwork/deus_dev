package deus;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import deus.core.soul.User;

public abstract class AbstractUseCaseTest {

	protected void testAttentionList(User user, int unnoticedElements, int noticedElements) {
		assertEquals("Number of unnoticed attention elements in " + user.getUserId()
				+ "'s attentionList is wrong!", unnoticedElements, user.getBarker().getUnnoticedAttentionList(user.getUserId()).size());
		assertEquals("Number of noticed attention elements in " + user.getUserId()
				+ "'s attentionList is wrong!", noticedElements, user.getBarker().getNoticedAttentionList(user.getUserId()).size());
	}



	protected void testDateNow(Date date) {
		assertEquals((new Date()).getTime(), date.getTime(), 500);
	}
}
