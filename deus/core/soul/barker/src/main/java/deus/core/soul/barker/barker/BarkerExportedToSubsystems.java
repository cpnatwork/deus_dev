package deus.core.soul.barker.barker;

import deus.model.barker.attention.AttentionElement;
import deus.model.common.user.id.UserId;


public interface BarkerExportedToSubsystems {

	public abstract void addUnnoticedAttentionElement(UserId userId, AttentionElement attentionElement);

}