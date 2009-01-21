package deus.core;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.barker.Barker;
import deus.model.user.id.UserId;
import deus.storage.attention.AttentionListDao;

public class UserFactory {

	@Autowired
	private AttentionListDao attentionListDao;
	
	public User createUser(UserId userId) {
		User user = new User();
		
		user.barker = new Barker();
		user.barker.setAttentionList(attentionListDao.getAttentionListForUser(userId));
		
		return user;
	}
	
}
