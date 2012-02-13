package deus.core.access.storage.inmemory.hci.attention;

import javax.inject.Named;

import deus.core.access.storage.api.hci.attention.AttentionElementDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;

@Named("attentionElementDao")
public class AttentionElementDaoImpl extends GenericTwofoldIdDaoImpl<AttentionElement, UserId, Integer> implements
		AttentionElementDao {

	@Override
	public void addNewEntity(UserId userId, AttentionElement attentionElement) {
		super.addNewEntity(userId, attentionElement.getId(), attentionElement);
	}


	@Override
	public void updateEntity(UserId userId, AttentionElement attentionElement) {
		super.updateEntity(userId, attentionElement.getId(), attentionElement);
	}

}
