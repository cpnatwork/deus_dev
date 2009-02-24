package deus.core.soul.decisionprocessor.impl;

import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.user.id.UserId;

interface GenericDecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(UserId userId, DecisionT decision);

}
