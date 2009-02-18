package deus.core.access.storage.attention.api;

import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

public interface AttentionDao {

	public AttentionList getUnnoticedAttentionList(UserId alOwnerUserId);
	
	public AttentionList getNoticedAttentionList(UserId alOwnerUserId);

	public void addNewEntity(AttentionElement attentionElement);

	public void noticeAttentionElement(AttentionElement attentionElement);
	
}
