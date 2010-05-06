package deus.core.soul.hci.decisionprocessor.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import deus.core.soul.hci.decisionprocessor.DecisionProcessor;
import deus.core.soul.hci.decisionprocessor.GenericDecisionProcessor;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.DecisionType;

@Named
public class DelegateDecisionProcessor implements DecisionProcessor {

	private Map<DecisionType, GenericDecisionProcessor<? extends BinaryDecisionToMake>> genericDecisionProcessors;


	public DelegateDecisionProcessor() {
		super();
		this.genericDecisionProcessors = new HashMap<DecisionType, GenericDecisionProcessor<? extends BinaryDecisionToMake>>();
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.common.decisionprocessor.impl.DecisionProcessor#process(deus.model.hci.attention.decision.BinaryDecisionToMake)
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
