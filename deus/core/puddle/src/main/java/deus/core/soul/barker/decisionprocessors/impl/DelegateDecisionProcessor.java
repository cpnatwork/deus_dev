package deus.core.soul.barker.decisionprocessors.impl;

import java.util.HashMap;
import java.util.Map;

import deus.core.soul.barker.decisionprocessors.DecisionProcessor;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.DecisionType;

public class DelegateDecisionProcessor implements DecisionProcessor<BinaryDecisionToMake> {

	private Map<DecisionType, DecisionProcessor<BinaryDecisionToMake>> decisionProcessors;


	public DelegateDecisionProcessor() {
		super();
		this.decisionProcessors = new HashMap<DecisionType, DecisionProcessor<BinaryDecisionToMake>>();
	}


	@Override
	public void process(BinaryDecisionToMake decision) {
		decisionProcessors.get(decision.getType()).process(decision);
	}


	// TODO: think about template parameter of this method
	public <T extends BinaryDecisionToMake> void addDecisionProcessor(DecisionProcessor<T> decisionProcessor,
			DecisionType type) {
		decisionProcessors.put(type, (DecisionProcessor<BinaryDecisionToMake>) decisionProcessor);
	}

}
