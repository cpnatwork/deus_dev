package deus.core.barker;

import deus.model.attention.decision.BinaryDecisionToMake;

public interface DecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(DecisionT decision);

}
