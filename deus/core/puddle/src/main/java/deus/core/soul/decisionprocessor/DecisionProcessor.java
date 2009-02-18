package deus.core.soul.decisionprocessor;

import deus.model.attention.decision.BinaryDecisionToMake;


public interface DecisionProcessor {

	public void process(BinaryDecisionToMake decision);

}