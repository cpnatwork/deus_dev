package deus.core.soul.decisionprocessor;

import deus.model.attention.decision.BinaryDecisionToMake;


public interface DecisionProcessor {

	public <T extends BinaryDecisionToMake> void process(T decision);

}