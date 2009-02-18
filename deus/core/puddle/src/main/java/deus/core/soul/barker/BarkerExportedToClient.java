package deus.core.soul.barker;

import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;


public interface BarkerExportedToClient {

	public abstract void noticeAttentionElement(AttentionElement attentionElement);


	public abstract AttentionList getUnnoticedAttentionList(UserId userId);


	public abstract AttentionList getNoticedAttentionList(UserId userId);

}