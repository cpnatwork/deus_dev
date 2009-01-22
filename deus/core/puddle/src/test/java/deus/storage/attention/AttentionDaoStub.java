package deus.storage.attention;

import javax.annotation.Resource;

import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

public class AttentionDaoStub implements AttentionDao {

	@Resource(name="attentionList")
	private AttentionList defaultList;
	
	public AttentionList getAttentionList(UserId id) {
		return defaultList;
	}
	
}
