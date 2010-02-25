package deus.core.access.storage.api.hci.attention;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;

public interface AttentionElementDao {

	public void addNewEntity(UserId userId, AttentionElement attentionElement);

	public void updateEntity(UserId userId, AttentionElement attentionElement);

}
