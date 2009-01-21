package deus.storage.attention;

import javax.annotation.Resource;

import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

public class AttentionListDaoMock implements AttentionListDao {

	@Resource(name="attentionList")
	private AttentionList defaultList;
	
	public AttentionList getAttentionListForUser(UserId id) {
		return defaultList;
	}
	
}
