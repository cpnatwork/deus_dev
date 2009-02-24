package deus.core.access.storage.api.attention;

import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

public interface AttentionListDoRep {

	AttentionList getUnnoticedAttentionList(UserId userId);

}
