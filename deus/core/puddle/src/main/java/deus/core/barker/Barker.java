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


	// TODO: remove this method and do creation of Barker and other classes by spring using @Configurable
	public void setAttentionList(AttentionList attentionList) {
		this.attentionList = attentionList;
	}
	
	// TODO: operations
	
}
