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
package deus.core.access.storage.api.subscription;

import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.LopEntry;

/**
 * The Interface LopEntryDao.
 */
public interface LopEntryDao {

	/**
	 * Gets the by natural id.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 * @return the by natural id
	 */
	LopEntry getByNaturalId(SubscriberId subscriberId, PublisherId publisherId);


	/**
	 * Update entity.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param entry
	 *            the entry
	 */
	void updateEntity(SubscriberId subscriberId, LopEntry entry);


	/**
	 * Delete by natural id.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	void deleteByNaturalId(SubscriberId subscriberId, PublisherId publisherId);


	/**
	 * Exists by natural id.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 * @return true, if successful
	 */
	boolean existsByNaturalId(SubscriberId subscriberId, PublisherId publisherId);


	/**
	 * Adds the new entity.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param entry
	 *            the entry
	 */
	void addNewEntity(SubscriberId subscriberId, LopEntry entry);

}
