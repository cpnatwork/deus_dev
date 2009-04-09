package deus.core.access.storage.api.archive.attention;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;

public interface AttentionElementDoRep {

	public void addNewEntity(UserId userId, AttentionElement attentionElement);
	
	public void updateEntity(UserId publisherId, AttentionElement attentionElement);

}
