package deus.core.soul.barker.decisionprocessor.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import deus.core.soul.barker.decisionprocessor.DecisionProcessor;
import deus.core.soul.barker.decisionprocessor.GenericDecisionProcessor;
import deus.model.barker.attention.BinaryDecisionToMake;
import deus.model.barker.attention.DecisionType;
import deus.model.common.user.id.UserId;

@Component
public class DelegateDecisionProcessor implements DecisionProcessor {

	private Map<DecisionType, GenericDecisionProcessor<? extends BinaryDecisionToMake>> genericDecisionProcessors;


	public DelegateDecisionProcessor() {
		super();
		this.genericDecisionProcessors = new HashMap<DecisionType, GenericDecisionProcessor<? extends BinaryDecisionToMake>>();
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.common.decisionprocessor.impl.DecisionProcessor#process(deus.model.barker.attention.decision.BinaryDecisionToMake)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends BinaryDecisionToMake> void process(UserId userId, T decision) {
		GenericDecisionProcessor<T> decisionProcessor = (GenericDecisionProcessor<T>)genericDecisionProcessors.get(decision.getType());
		decisionProcessor.process(userId, decision);
	}


	public <T extends BinaryDecisionToMake> void addDecisionProcessor(GenericDecisionProcessor<T> decisionProcessor,
			DecisionType type) {
		genericDecisionProcessors.put(type, decisionProcessor);
	}

}
