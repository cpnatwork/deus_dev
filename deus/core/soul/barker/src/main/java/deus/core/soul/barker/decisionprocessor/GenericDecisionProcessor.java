package deus.core.soul.barker.decisionprocessor;

import deus.model.barker.attention.BinaryDecisionToMake;
import deus.model.common.user.id.UserId;

public interface GenericDecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(UserId userId, DecisionT decision);

}
