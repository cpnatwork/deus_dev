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
package deus.core.soul.repatriationhub.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.soul.hci.barker.BarkerExportedToSubsystems;
import deus.core.soul.pifgoverning.PifGovernorExportedToSubsystems;
import deus.core.soul.repatriationhub.RepatriationHub;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.repatriation.Repatriation;

/**
 * The Class RepatriationHubImpl.
 */
@Named("repatriationHub")
public class RepatriationHubImpl implements RepatriationHub {

	/** The pif governor. */
	@Inject
	private PifGovernorExportedToSubsystems pifGovernor;

	/** The barker. */
	@Inject
	private BarkerExportedToSubsystems barker;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.transfer.core.receiving.soulcallback.repatriationhub
	 * .RepatriationHubExportedToPeers
	 * #accept(deus.model.common.user.frids.RepatriationAuthorityId,
	 * deus.model.common.user.frids.ContributorId,
	 * deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public void accept(final RepatriationAuthorityId repatriationAuthorityId,
			final ContributorId contributorId,
			final DigitalCard repatriatedDigitalCard) {
		if (!repatriationAuthorityId.equals(repatriatedDigitalCard
				.getDigitalCardId().getCpId()))
			throw new IllegalArgumentException(
					"ID of the CP is not the ID of the user, that is handled in this repatriation hub");

		if (!contributorId.equals(repatriatedDigitalCard.getDigitalCardId()
				.getContributorId()))
			throw new IllegalArgumentException(
					"ID of the informationProvider does not match the id in the digital card!");

		// IMPORTANT SHORTCUT: always allow myself to contribute changes!
		if (repatriationAuthorityId.equals(contributorId)) {
			// if 'I' am the informationProvider
			this.pifGovernor.assimilateRepatriatedDigitalCard(
					repatriationAuthorityId, repatriatedDigitalCard);
		} else {
			// if the informationProvider is another person

			// FIXME: do contributors need to register before contributing????
			// if not, than a UserMetadata of should be passed to contribute()
			// otherwise a Map<UserId, UserMetadata> of the contributors should
			// be added

			final UserMetadata contributorMetadata = null;

			final BinaryDecisionToMake decision = new Repatriation(
					contributorMetadata, repatriatedDigitalCard);
			this.barker.addUnnoticedAttentionElement(
					repatriationAuthorityId.getUserId(), decision);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.soul.repatriationhub.RepatriationHubExportedToClient#
	 * fireAndForgetAccept(deus.model.common.user.id.UserId,
	 * deus.model.common.dossier.DigitalCard)
	 */
	@Override
	@Deprecated
	public void fireAndForgetAccept(final UserId cpId,
			final DigitalCard repatriatedDigitalCard) {
		throw new UnsupportedOperationException(
				"fireAndForgetAccept is not implemented yet");
	}

}
