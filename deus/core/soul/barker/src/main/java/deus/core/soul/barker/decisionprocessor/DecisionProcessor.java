package deus.core.soul.barker.decisionprocessor;

import deus.model.barker.attention.BinaryDecisionToMake;
import deus.model.common.user.id.UserId;

public interface DecisionProcessor {

	public <T extends BinaryDecisionToMake> void process(UserId userId, T decision);

}