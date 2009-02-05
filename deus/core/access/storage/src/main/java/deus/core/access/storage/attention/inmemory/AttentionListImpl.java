package deus.core.access.storage.attention.inmemory;

import java.util.ArrayList;
import java.util.Collection;

import deus.model.attention.AttentionElement;
import deus.model.attention.AttentionList;

public class AttentionListImpl extends ArrayList<AttentionElement> implements AttentionList {

	private static final long serialVersionUID = 5317622867565221648L;


	public AttentionListImpl() {
		super();
	}


	public AttentionListImpl(Collection<? extends AttentionElement> c) {
		super(c);
	}

}
