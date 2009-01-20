package deus.core.barker;

import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;

public class Barker {

	private AttentionList attentionList;

	public void addAttentionElement(AttentionElement attentionElement) {
		attentionList.add(attentionElement);
	}
	
	
	// CPN: really return this list (it can be changed!)? 
	public AttentionList getAttentionList() {
		return attentionList;
	}
	
	// TODO: operations
	
}
