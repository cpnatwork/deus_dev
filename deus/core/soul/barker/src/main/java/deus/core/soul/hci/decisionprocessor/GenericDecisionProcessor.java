package deus.core.soul.hci.decisionprocessor;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;

public interface GenericDecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(UserId userId, DecisionT decision);

}
