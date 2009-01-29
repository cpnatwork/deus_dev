package deus.core.soul.barker.decisionprocessors;

import deus.model.attention.decision.BinaryDecisionToMake;

public interface DecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(DecisionT decision);

}
