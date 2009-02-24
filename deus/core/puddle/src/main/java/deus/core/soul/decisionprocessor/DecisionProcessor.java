package deus.core.soul.decisionprocessor;

import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.user.id.UserId;


public interface DecisionProcessor {

	public <T extends BinaryDecisionToMake> void process(UserId userId, T decision);

}