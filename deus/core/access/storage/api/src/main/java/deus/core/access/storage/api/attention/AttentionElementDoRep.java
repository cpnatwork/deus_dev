package deus.core.access.storage.api.attention;

import deus.model.attention.AttentionElement;
import deus.model.user.id.UserId;

public interface AttentionElementDoRep {

	public void addNewEntity(UserId userId, AttentionElement attentionElement);
	
	public void updateEntity(UserId publisherId, AttentionElement attentionElement);

}
