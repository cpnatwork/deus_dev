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
package deus.core.soul.contribution.impl;

import javax.inject.Inject;

import deus.core.access.transfer.core.sending.command.ContributionCommandSender;
import deus.core.soul.contribution.Contributor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

/**
 * The Class ContributorImpl.
 */
public class ContributorImpl implements Contributor {

	/** The contribution command sender. */
	@Inject
	private ContributionCommandSender contributionCommandSender;
	
	/* (non-Javadoc)
	 * @see deus.core.soul.contribution.ContributorExportedToClient#contributeCp(deus.model.common.user.frids.ContributorId, deus.model.common.user.frids.RepatriationAuthorityId, deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public void contributeCp(ContributorId contributorId, RepatriationAuthorityId repatriationAuthorityId, DigitalCard digitalCard) {
		contributionCommandSender.forwardToCp(contributorId, repatriationAuthorityId, digitalCard);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.contribution.ContributorExportedToPeers#contributionAcknowledged(deus.model.common.user.frids.ContributorId, deus.model.common.dossier.DigitalCardId)
	 */
	@Override
	public void contributionAcknowledged(ContributorId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transfer to acknowledge the contribution, add a notice to barker)
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.contribution.ContributorExportedToPeers#contributionDenied(deus.model.common.user.frids.ContributorId, deus.model.common.dossier.DigitalCardId)
	 */
	@Override
	public void contributionDenied(ContributorId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transfer to tell the denial of the contribution, add a notice to barker)
	}

}