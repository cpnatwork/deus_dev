package deus.model.attention;

public abstract class BinaryDecisionToMake extends AttentionElement {

	private Boolean decision = null;
	
	public final void setDecisionPositive() {
		decision = true;
	}
	
	public final void setDecisionNegative() {
		decision = false;
	}
	
	public final boolean isProcessed() {
		return decision != null;
	}
	
	private final void assertIsProcessed() {
		if(!isProcessed())
			throw new IllegalStateException("decision is not processed yet!");
	}

	public final boolean isDecisionPositive() {
		assertIsProcessed();
		return decision == true;
	}

	public final boolean isDecisionNegative() {
		assertIsProcessed();
		return decision == false;
	}
		
}
