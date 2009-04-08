package deus.model.hci.attention;

import java.util.List;

import deus.model.common.user.id.UserId;

public interface AttentionList extends List<AttentionElement> {

	public UserId getUserId();
	
}
