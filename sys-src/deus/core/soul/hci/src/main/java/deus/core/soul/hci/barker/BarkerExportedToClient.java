package deus.core.soul.hci.barker;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;
import deus.model.hci.attention.AttentionList;


public interface BarkerExportedToClient {

	/**
	 * 
	 * @param userId
	 * @param attentionElement
	 * 
	 * @throws BarkerRuntimeException thrown if the passed <code>AttentionElement</code> is already noticed.
	 */
	public abstract void noticeAttentionElement(UserId userId, AttentionElement attentionElement);


	public abstract AttentionList getUnnoticedAttentionList(UserId userId);


	public abstract AttentionList getNoticedAttentionList(UserId userId);

}