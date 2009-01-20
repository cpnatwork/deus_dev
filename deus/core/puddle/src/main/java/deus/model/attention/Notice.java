package deus.model.attention;

public abstract class Notice extends AttentionElement {

	private boolean processed;


	public final boolean isProcessed() {
		return processed;
	}


	public final void process() {
		processed = true;
	}

}
