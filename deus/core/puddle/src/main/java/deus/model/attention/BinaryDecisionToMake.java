package deus.model.attention;

public abstract class BinaryDecisionToMake extends AttentionElement {

	private Boolean decision = null;
	
	public void setDecisionPositive() {
		decision = true;
	}
	
	public void setDecisionNegative() {
		decision = false;
	}
	
	public boolean isProcessed() {
		return decision != null;
	}
	
	private void assertIsProcessed() {
		if(!isProcessed())
			throw new IllegalStateException("decision is not processed yet!");
	}

	public boolean isDecisionPositive() {
		assertIsProcessed();
		return decision == true;
	}

	public boolean isDecisionNegative() {
		assertIsProcessed();
		return decision == false;
	}
		
}
