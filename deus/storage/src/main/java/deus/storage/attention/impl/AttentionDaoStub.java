package deus.storage.attention.impl;

import org.springframework.stereotype.Component;

import deus.model.attention.AttentionList;
import deus.model.attention.impl.AttentionListImpl;
import deus.model.user.id.UserId;
import deus.storage.attention.AttentionDao;

@Component
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
