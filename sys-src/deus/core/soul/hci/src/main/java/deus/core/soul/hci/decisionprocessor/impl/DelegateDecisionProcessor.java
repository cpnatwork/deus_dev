/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus.core.soul.hci.decisionprocessor.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import deus.core.soul.hci.decisionprocessor.DecisionProcessor;
import deus.core.soul.hci.decisionprocessor.GenericDecisionProcessor;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.DecisionType;

/**
 * The Class DelegateDecisionProcessor.
 */
@Named
public class DelegateDecisionProcessor implements DecisionProcessor {

	/** The generic decision processors. */
	private Map<DecisionType, GenericDecisionProcessor<? extends BinaryDecisionToMake>> genericDecisionProcessors;


	/**
	 * Instantiates a new delegate decision processor.
	 */
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


	/**
	 * Adds the decision processor.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param decisionProcessor
	 *            the decision processor
	 * @param type
	 *            the type
	 */
	public <T extends BinaryDecisionToMake> void addDecisionProcessor(GenericDecisionProcessor<T> decisionProcessor,
			DecisionType type) {
		genericDecisionProcessors.put(type, decisionProcessor);
	}

}
