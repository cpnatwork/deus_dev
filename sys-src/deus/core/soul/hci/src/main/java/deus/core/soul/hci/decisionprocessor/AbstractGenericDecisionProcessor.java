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
package deus.core.soul.hci.decisionprocessor;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;

/**
 * The Class AbstractGenericDecisionProcessor.
 * 
 * @param <DecisionT>
 *            the generic type
 */
public abstract class AbstractGenericDecisionProcessor<DecisionT extends BinaryDecisionToMake>
		implements GenericDecisionProcessor<DecisionT> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.hci.decisionprocessor.GenericDecisionProcessor#process
	 * (deus.model.common.user.id.UserId,
	 * deus.model.hci.attention.BinaryDecisionToMake)
	 */
	@Override
	public final void process(final UserId userId, final DecisionT decision) {
		if (!decision.isDecisionMade())
			throw new IllegalStateException("decision (" + decision
					+ ") is not made yet");

		this.processImpl(userId, decision);
	}

	/**
	 * Process impl.
	 * 
	 * @param userId
	 *            the user id
	 * @param decision
	 *            the decision
	 */
	protected abstract void processImpl(UserId userId, DecisionT decision);

}
