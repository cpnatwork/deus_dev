package deus.core.soul.common.decisionprocessor;

import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.user.id.UserId;

public interface GenericDecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(UserId userId, DecisionT decision);

}
