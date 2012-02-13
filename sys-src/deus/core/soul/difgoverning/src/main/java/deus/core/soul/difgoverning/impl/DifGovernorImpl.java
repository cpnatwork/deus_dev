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
package deus.core.soul.difgoverning.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.difgoverning.FifDao;
import deus.core.soul.difgoverning.DifGovernor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.common.user.id.UserId;
import deus.model.difgoverning.ForeignInformationFile;

/**
 * The Class DifGovernorImpl.
 */
@Named("difGovernor")
public class DifGovernorImpl implements DifGovernor {

	/** The patch strategy. */
	@Inject
	private PatchStrategy patchStrategy;


	/** The fif dao. */
	@Inject
	private FifDao fifDao;


	/* (non-Javadoc)
	 * @see deus.core.soul.difgoverning.DifGovernorExportedToSubsystems#applyPatch(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId, deus.model.common.dossier.Patch)
	 */
	@Override
	public void applyPatch(SubscriberId subscriberId, PublisherId publisherId, Patch patch) {
		ForeignInformationFile foreignInformationFile = fifDao.getByNaturalId(subscriberId, publisherId);

		patchStrategy.patch(foreignInformationFile, patch);

		fifDao.updateEntity(subscriberId, publisherId, foreignInformationFile);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.difgoverning.DifGovernorExportedToClient#getPublishersInDif(deus.model.common.user.id.UserId)
	 */
	@Override
	public List<UserId> getPublishersInDif(UserId subscriberId) {
		// FIXME: implement
		return null;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.difgoverning.DifGovernorExportedToClient#getDigitalCardIdsInFif(deus.model.common.user.id.UserId, deus.model.common.user.id.UserId)
	 */
	@Override
	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId, UserId publisherId) {
		// FIXME: implement
		return null;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.difgoverning.DifGovernorExportedToClient#getDigitalCardInFif(deus.model.common.user.id.UserId, deus.model.common.dossier.DigitalCardId)
	 */
	@Override
	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId) {
		// FIXME: implement
		return null;
	}

}
