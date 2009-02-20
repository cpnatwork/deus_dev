package deus.core.access.storage.attention.hibernate;

import deus.core.access.storage.attention.api.AttentionDao;
import deus.core.access.storage.attention.inmemory.AttentionListImpl;
import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;


public class AttentionDaoHibernateImpl implements AttentionDao {

	@Override
	public AttentionList getNoticedAttentionList(UserId alOwnerUserId) {
		return new AttentionListImpl();
	}

	@Override
	public AttentionList getUnnoticedAttentionList(UserId alOwnerUserId) {
		return new AttentionListImpl();
	}

	@Override
	public void addNewEntity(AttentionElement attentionElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noticeAttentionElement(AttentionElement attentionElement) {
		// TODO Auto-generated method stub
		
	}
	
}
