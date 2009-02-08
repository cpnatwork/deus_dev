package deus.core.access.storage.attention.hibernate;

import deus.core.access.storage.attention.api.AttentionDao;
import deus.core.access.storage.attention.inmemory.AttentionListImpl;
import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;


public class AttentionDaoImpl implements AttentionDao {

	@Override
	public AttentionList getNoticedAttentionList(UserId alOwnerUserId) {
		return new AttentionListImpl();
	}

	@Override
	public AttentionList getUnnoticedAttentionList(UserId alOwnerUserId) {
		return new AttentionListImpl();
	}
	
}
