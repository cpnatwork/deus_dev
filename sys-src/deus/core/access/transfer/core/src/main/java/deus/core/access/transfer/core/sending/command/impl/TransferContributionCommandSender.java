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
package deus.core.access.transfer.core.sending.command.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.repatriation.ContributeMessage;
import deus.core.access.transfer.core.sending.command.ContributionCommandSender;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

/**
 * The Class TransferContributionCommandSender.
 */
@Named("contributionCommandSender")
public class TransferContributionCommandSender implements
		ContributionCommandSender {

	/** The transfer message sender helper. */
	@Inject
	private TransferMessageSenderHelper transferMessageSenderHelper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.transfer.core.sending.command.ContributionCommandSender
	 * #forwardToCp(deus.model.common.user.frids.ContributorId,
	 * deus.model.common.user.frids.RepatriationAuthorityId,
	 * deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public void forwardToCp(final ContributorId contributorId,
			final RepatriationAuthorityId repatriationAuthorityId,
			final DigitalCard digitalCard) {
		final TransferMessage transferMessage = new ContributeMessage(
				digitalCard);
		this.transferMessageSenderHelper.send(
				repatriationAuthorityId.getUserId(), contributorId.getUserId(),
				transferMessage);
	}

}
