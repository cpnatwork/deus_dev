package deus.core.soul.barker.decisionprocessor;

import deus.model.attention.BinaryDecisionToMake;
import deus.model.user.id.UserId;

public interface GenericDecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(UserId userId, DecisionT decision);

}
