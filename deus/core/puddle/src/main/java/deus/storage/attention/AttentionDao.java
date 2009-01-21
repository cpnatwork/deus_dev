package deus.storage.attention;

import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;

public interface AttentionDao {

	public AttentionList getAttentionList(UserId id);
	
}
