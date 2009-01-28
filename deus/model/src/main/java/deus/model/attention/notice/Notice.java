package deus.model.attention.notice;

import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionElementType;

public abstract class Notice extends AttentionElement {

	public final AttentionElementType getAttentionElementType() {
		return AttentionElementType.notice;
	}
	
}
