package deus.core.access.storage.api.attention;

import deus.model.barker.attention.AttentionList;
import deus.model.common.user.id.UserId;

public interface AttentionListDoRep {

	AttentionList getUnnoticedAttentionList(UserId userId);

}
