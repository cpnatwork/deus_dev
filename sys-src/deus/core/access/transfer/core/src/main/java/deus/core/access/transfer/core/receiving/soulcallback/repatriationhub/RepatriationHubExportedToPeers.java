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
package deus.core.access.transfer.core.receiving.soulcallback.repatriationhub;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

// FIXME: edit javadoc
/**
 * The Interface RepatriationHubExportedToPeers.
 */
public interface RepatriationHubExportedToPeers {

	// TODO: add to javadoc: an acknowledgement is sent

	/**
	 * This method is used to contribute a digital card to a foreign PIF, i.e.
	 * the informationProvider is not the owner of the PIF and the contribution
	 * is checked by adding an attention element to the barker. Only after the
	 * decision to contribute this digital card is made, it is committed to the
	 * PIF.
	 * 
	 * @param repatriationAuthorityId
	 *            the repatriation authority id
	 * @param contributorId
	 *            the user ID of the informationProvider
	 * @param repatriatedDigitalCard
	 *            the digital card to contribute
	 */
	public abstract void accept(
			RepatriationAuthorityId repatriationAuthorityId,
			ContributorId contributorId, DigitalCard repatriatedDigitalCard);

}