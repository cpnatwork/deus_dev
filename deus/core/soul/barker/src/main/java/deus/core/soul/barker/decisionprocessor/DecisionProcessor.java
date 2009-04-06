package deus.core.soul.barker.decisionprocessor;

import deus.model.attention.BinaryDecisionToMake;
import deus.model.user.id.UserId;

public interface DecisionProcessor {

	public <T extends BinaryDecisionToMake> void process(UserId userId, T decision);

}