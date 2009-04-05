package deus.core.soul.barker.decisionprocessor;

import deus.model.attention.BinaryDecisionToMake;
import deus.model.user.id.UserId;

// FIXME: move all classes around decision processor to Barker subsystem
public interface DecisionProcessor {

	public <T extends BinaryDecisionToMake> void process(UserId userId, T decision);

}