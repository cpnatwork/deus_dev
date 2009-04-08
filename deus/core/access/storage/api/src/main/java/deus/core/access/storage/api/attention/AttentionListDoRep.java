package deus.core.access.storage.api.attention;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionList;

public interface AttentionListDoRep {

	AttentionList getUnnoticedAttentionList(UserId userId);

}
