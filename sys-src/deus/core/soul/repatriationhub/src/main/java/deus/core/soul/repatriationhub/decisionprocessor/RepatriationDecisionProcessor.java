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
package deus.core.soul.repatriationhub.decisionprocessor;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.soul.hci.decisionprocessor.AbstractGenericDecisionProcessor;
import deus.core.soul.pifgoverning.PifGovernorExportedToSubsystems;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.repatriation.Repatriation;

/**
 * The Class RepatriationDecisionProcessor.
 */
@Named
public class RepatriationDecisionProcessor extends AbstractGenericDecisionProcessor<Repatriation> {

	/** The pif governor. */
	@Inject
	public PifGovernorExportedToSubsystems pifGovernor;


	/* (non-Javadoc)
	 * @see deus.core.soul.hci.decisionprocessor.AbstractGenericDecisionProcessor#processImpl(deus.model.common.user.id.UserId, deus.model.hci.attention.BinaryDecisionToMake)
	 */
	@Override
	protected void processImpl(UserId userId, Repatriation contributionDecision) {
		if (contributionDecision.isDecisionPositive()) {
			pifGovernor.assimilateRepatriatedDigitalCard(new RepatriationAuthorityId(userId), contributionDecision.getContributedDigitalCard());
			
			// FIXME: call contrib.Acked on informationProvider
		}
		else {
			// FIXME: call contrib.Denied on informationProvider
		}
	}

}
