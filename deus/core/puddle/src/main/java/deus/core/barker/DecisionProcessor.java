package deus.core.barker;

import deus.model.attention.BinaryDecisionToMake;

public interface DecisionProcessor<DecisionT extends BinaryDecisionToMake> {

	public void process(DecisionT decision);

}
