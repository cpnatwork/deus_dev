package deus.model.dossier;

import deus.model.user.id.UserId;

abstract class ContainerCard<T, Id extends UserId> extends DigitalCard<Id> {

	private T root;

	public T getRoot() {
		return root;
	}

	public void setRoot(T root) {
		this.root = root;
	}
	
}
