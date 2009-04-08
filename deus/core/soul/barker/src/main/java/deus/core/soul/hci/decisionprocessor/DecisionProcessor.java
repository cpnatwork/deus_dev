package deus.core.soul.hci.decisionprocessor;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;

public interface DecisionProcessor {

	public <T extends BinaryDecisionToMake> void process(UserId userId, T decision);

}