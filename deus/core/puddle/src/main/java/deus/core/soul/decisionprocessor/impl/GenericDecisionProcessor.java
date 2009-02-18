package deus.core.soul.decisionprocessor.impl;

import deus.model.attention.decision.BinaryDecisionToMake;

interface GenericDecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(DecisionT decision);

}
