package deus.core.soul.decisionprocessor.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import deus.core.soul.decisionprocessor.DecisionProcessor;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.DecisionType;

@Component
public class DelegateDecisionProcessor implements DecisionProcessor {

	private Map<DecisionType, GenericDecisionProcessor<BinaryDecisionToMake>> genericDecisionProcessors;


	public DelegateDecisionProcessor() {
		super();
		this.genericDecisionProcessors = new HashMap<DecisionType, GenericDecisionProcessor<BinaryDecisionToMake>>();
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.decisionprocessor.impl.DecisionProcessor#process(deus.model.attention.decision.BinaryDecisionToMake)
	 */
	@Override
	public void process(BinaryDecisionToMake decision) {
		genericDecisionProcessors.get(decision.getType()).process(decision);
	}


	public <T extends BinaryDecisionToMake> void addDecisionProcessor(GenericDecisionProcessor<T> decisionProcessor,
			DecisionType type) {
		genericDecisionProcessors.put(type, (GenericDecisionProcessor<BinaryDecisionToMake>) decisionProcessor);
	}

}
