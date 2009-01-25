package deus.model.attention;

public abstract class BinaryDecisionToMake extends AttentionElement {

	private Boolean decision = null;

	public final boolean isDecisionMade() {
		return decision != null;
	}

	public final void setDecisionPositive() {
		decision = true;
	}


	public final void setDecisionNegative() {
		decision = false;
	}


	private final void assertIsDecisionMade() {
		if (!isDecisionMade())
			throw new IllegalStateException("decision is not made yet!");
	}


	public final boolean isDecisionPositive() {
		assertIsDecisionMade();
		return decision == true;
	}


	public final boolean isDecisionNegative() {
		assertIsDecisionMade();
		return decision == false;
	}

	public abstract DecisionType getType();

}
