package deus.model.attention;

public abstract class Notice extends AttentionElement {

	private boolean processed;


	public boolean isProcessed() {
		return processed;
	}


	public void process() {
		processed = true;
	}

}
