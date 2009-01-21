package deus.storage.attention;

import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

public interface AttentionListDao {

	public AttentionList getAttentionListForUser(UserId id);
	
}
