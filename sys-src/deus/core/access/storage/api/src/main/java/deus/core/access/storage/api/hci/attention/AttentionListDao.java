package deus.core.access.storage.api.hci.attention;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionList;

public interface AttentionListDao {

	public AttentionList getUnnoticedAttentionList(UserId userId);

	public AttentionList getNoticedAttentionList(UserId userId);

}
