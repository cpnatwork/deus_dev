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
package deus.core.soul.pifgoverning.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.storage.api.pifgoverning.PifDao;
import deus.core.soul.pifgoverning.AssimilationStrategy;
import deus.core.soul.pifgoverning.PifGovernor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.pifgoverning.PersonalInformationFile;

/**
 * The Class PifGovernorImpl.
 */
@Named("pifGovernor")
public class PifGovernorImpl implements PifGovernor {

	/** The assimilation strategy. */
	@Inject
	private AssimilationStrategy assimilationStrategy;


	/** The pif dao. */
	@Inject
	private PifDao pifDao;
	

	/* (non-Javadoc)
	 * @see deus.core.soul.pifgoverning.PifGovernorExportedToSubsystems#assimilateRepatriatedDigitalCard(deus.model.common.user.frids.RepatriationAuthorityId, deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public Patch assimilateRepatriatedDigitalCard(RepatriationAuthorityId repatriationAuthorityId, DigitalCard digitalCard) {
		PersonalInformationFile personalInformationFile = pifDao.getByNaturalId(repatriationAuthorityId);

		Patch patch = assimilationStrategy.update(personalInformationFile, digitalCard);

		pifDao.updateEntity(repatriationAuthorityId, personalInformationFile);
		
		return patch;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.pifgoverning.PifGovernorExportedToClient#getPersonalInformationFile(deus.model.common.user.frids.RepatriationAuthorityId)
	 */
	@Override
	public PersonalInformationFile getPersonalInformationFile(RepatriationAuthorityId repatriationAuthorityId) {
		return pifDao.getByNaturalId(repatriationAuthorityId);
	}

}
