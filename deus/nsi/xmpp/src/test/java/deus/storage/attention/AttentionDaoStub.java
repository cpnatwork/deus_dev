package deus.storage.attention;

import deus.model.attention.AttentionList;
import deus.model.attention.impl.AttentionListImpl;
import deus.model.user.id.UserId;

public class AttentionDaoStub implements AttentionDao {

	@Override
	public AttentionList getNoticedAttentionList(UserId id) {
		return new AttentionListImpl();
	}

	@Override
	public AttentionList getUnnoticedAttentionList(UserId id) {
		return new AttentionListImpl();
	}
	
}
