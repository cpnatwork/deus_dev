package deus.core.soul.barker.barker;

import deus.model.barker.attention.AttentionElement;
import deus.model.barker.attention.AttentionList;
import deus.model.common.user.id.UserId;


public interface BarkerExportedToClient {

	public abstract void noticeAttentionElement(UserId userId, AttentionElement attentionElement);


	public abstract AttentionList getUnnoticedAttentionList(UserId userId);


	public abstract AttentionList getNoticedAttentionList(UserId userId);

}