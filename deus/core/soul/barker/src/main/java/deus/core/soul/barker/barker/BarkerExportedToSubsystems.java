package deus.core.soul.barker.barker;

import deus.model.attention.AttentionElement;
import deus.model.user.id.UserId;


public interface BarkerExportedToSubsystems {

	public abstract void addUnnoticedAttentionElement(UserId userId, AttentionElement attentionElement);

}