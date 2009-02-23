package deus.model.attention;

import java.util.List;

import deus.model.user.id.UserId;

public interface AttentionList extends List<AttentionElement> {

	public UserId getUserId();
	
}
