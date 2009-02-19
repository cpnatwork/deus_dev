package deus.core.soul.decisionprocessor.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import deus.core.soul.decisionprocessor.DecisionProcessor;
import deus.model.attention.decision.BinaryDecisionToMake;
import deus.model.attention.decision.DecisionType;

@Component
public class DelegateDecisionProcessor implements DecisionProcessor {

	private Map<DecisionType, GenericDecisionProcessor<? extends BinaryDecisionToMake>> genericDecisionProcessors;


	public DelegateDecisionProcessor() {
		super();
		this.genericDecisionProcessors = new HashMap<DecisionType, GenericDecisionProcessor<? extends BinaryDecisionToMake>>();
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.decisionprocessor.impl.DecisionProcessor#process(deus.model.attention.decision.BinaryDecisionToMake)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends BinaryDecisionToMake> void process(T decision) {
		GenericDecisionProcessor<T> decisionProcessor = (GenericDecisionProcessor<T>)genericDecisionProcessors.get(decision.getType());
		decisionProcessor.process(decision);
	}


	public <T extends BinaryDecisionToMake> void addDecisionProcessor(GenericDecisionProcessor<T> decisionProcessor,
			DecisionType type) {
		genericDecisionProcessors.put(type, decisionProcessor);
	}

}
