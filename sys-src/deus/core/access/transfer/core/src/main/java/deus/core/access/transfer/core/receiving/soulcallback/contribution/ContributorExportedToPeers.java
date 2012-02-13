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
package deus.core.access.transfer.core.receiving.soulcallback.contribution;

import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.frids.ContributorId;

/**
 * The Interface ContributorExportedToPeers.
 */
public interface ContributorExportedToPeers {

	/**
	 * Contribution acknowledged.
	 * 
	 * @param contributorId
	 *            the contributor id
	 * @param digitalCardId
	 *            the digital card id
	 */
	public void contributionAcknowledged(ContributorId contributorId,
			DigitalCardId digitalCardId);

	/**
	 * Contribution denied.
	 * 
	 * @param contributorId
	 *            the contributor id
	 * @param digitalCardId
	 *            the digital card id
	 */
	public void contributionDenied(ContributorId contributorId,
			DigitalCardId digitalCardId);

}
