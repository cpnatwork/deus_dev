package deus.gatekeeper.cerberus.impl;

import deus.core.access.storage.api.attention.AttentionDao;
import deus.core.access.storage.api.attention.AttentionListImpl;
import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

public class AttentionDaoStub implements AttentionDao {

	@Override
	public void addNewEntity(AttentionElement attentionElement) {
		// TODO Auto-generated method stub

	}


	@Override
	public void createAttentionList(AttentionListImpl attentionListImpl) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteAttentionList(UserId userId) {
		// TODO Auto-generated method stub

	}


	@Override
	public AttentionList getNoticedAttentionList(UserId alOwnerUserId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AttentionList getUnnoticedAttentionList(UserId alOwnerUserId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void noticeAttentionElement(AttentionElement attentionElement) {
		// TODO Auto-generated method stub

	}

}
