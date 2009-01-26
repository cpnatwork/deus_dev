package deus.core.barker.decisionprocessors.impl;

import java.util.Map;

import deus.core.barker.decisionprocessors.DecisionProcessor;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.DecisionType;

public class DelegateDecisionProcessor implements DecisionProcessor<BinaryDecisionToMake> {

	private Map<DecisionType, DecisionProcessor<BinaryDecisionToMake>> decisionProcessors;
	
	@Override
	public void process(BinaryDecisionToMake decision) {
		decisionProcessors.get(decision.getType()).process(decision);
	}
	
	// TODO: think about template parameter of this method
	public <T extends BinaryDecisionToMake> void addDecisionProcessor(DecisionProcessor<T> decisionProcessor, DecisionType type) {
		decisionProcessors.put(type, (DecisionProcessor<BinaryDecisionToMake>)decisionProcessor);
	}
	
}
