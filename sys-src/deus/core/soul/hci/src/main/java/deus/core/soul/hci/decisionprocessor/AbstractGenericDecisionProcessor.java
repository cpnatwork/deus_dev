package deus.core.soul.hci.decisionprocessor;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;

public abstract class AbstractGenericDecisionProcessor<DecisionT extends BinaryDecisionToMake> implements
		GenericDecisionProcessor<DecisionT> {

	@Override
	public final void process(UserId userId, DecisionT decision) {
		if (!decision.isDecisionMade())
			throw new IllegalStateException("decision (" + decision + ") is not made yet");

		processImpl(userId, decision);
	}


	protected abstract void processImpl(UserId userId, DecisionT decision);

}
