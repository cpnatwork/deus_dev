package deus.core.soul.hci.barker;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;


public interface BarkerExportedToSubsystems {

	public abstract void addUnnoticedAttentionElement(UserId userId, AttentionElement attentionElement);

}