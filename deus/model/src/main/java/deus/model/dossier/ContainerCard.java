package deus.model.dossier;


abstract class ContainerCard<T> extends DigitalCard {

	private T root;

	public T getRoot() {
		return root;
	}

	public void setRoot(T root) {
		this.root = root;
	}
	
}
