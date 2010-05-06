package deus.core.access.storage.inmemory.hci.attention;

import javax.inject.Named;

import deus.core.access.storage.api.hci.attention.AttentionListDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionList;

@Named("attentionListDao")
public class AttentionListDaoImpl extends GenericVanillaDaoImpl<AttentionList, UserId> implements AttentionListDao {

	@Override
	public AttentionList getNoticedAttentionList(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttentionList getUnnoticedAttentionList(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
