package deus.core.access.storage.attention.hibernate;

import org.springframework.stereotype.Component;

import deus.core.access.storage.attention.api.AttentionDao;
import deus.model.attention.AttentionList;
import deus.model.attention.impl.AttentionListImpl;
import deus.model.user.id.UserId;

@Component
public class AttentionDaoHibernate implements AttentionDao {

	@Override
	public AttentionList getNoticedAttentionList(UserId alOwnerUserId) {
		return new AttentionListImpl();
	}

	@Override
	public AttentionList getUnnoticedAttentionList(UserId alOwnerUserId) {
		return new AttentionListImpl();
	}
	
}
