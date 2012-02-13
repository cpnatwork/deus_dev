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
package deus.core.access.storage.api.pifgoverning;

import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.pifgoverning.PersonalInformationFile;

/**
 * The Interface PifDao.
 */
public interface PifDao {

	/**
	 * Gets the by natural id.
	 * 
	 * @param repatriationAuthorityId
	 *            the repatriation authority id
	 * @return the by natural id
	 */
	PersonalInformationFile getByNaturalId(RepatriationAuthorityId repatriationAuthorityId);

	/**
	 * Update entity.
	 * 
	 * @param repatriationAuthorityId
	 *            the repatriation authority id
	 * @param personalInformationFile
	 *            the personal information file
	 */
	void updateEntity(RepatriationAuthorityId repatriationAuthorityId, PersonalInformationFile personalInformationFile);

}
