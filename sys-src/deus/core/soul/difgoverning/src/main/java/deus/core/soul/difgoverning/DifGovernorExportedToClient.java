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
package deus.core.soul.difgoverning;

import java.util.List;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.id.UserId;

/**
 * The Interface DifGovernorExportedToClient.
 */
public interface DifGovernorExportedToClient {

	/**
	 * Gets the publishers in dif.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @return the publishers in dif
	 */
	public List<UserId> getPublishersInDif(UserId subscriberId);

	/**
	 * Gets the digital card ids in fif.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 * @return the digital card ids in fif
	 */
	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId,
			UserId publisherId);

	/**
	 * Gets the digital card in fif.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param digitalCardId
	 *            the digital card id
	 * @return the digital card in fif
	 */
	public DigitalCard getDigitalCardInFif(UserId subscriberId,
			DigitalCardId digitalCardId);

}
