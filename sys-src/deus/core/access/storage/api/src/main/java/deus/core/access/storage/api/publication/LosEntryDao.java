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
package deus.core.access.storage.api.publication;

import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.LosEntry;

/**
 * The Interface LosEntryDao.
 */
public interface LosEntryDao {

	/**
	 * Gets the by natural id.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 * @return the by natural id
	 */
	public LosEntry getByNaturalId(PublisherId publisherId, SubscriberId subscriberId);


	/**
	 * Delete by natural id.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public void deleteByNaturalId(PublisherId publisherId, SubscriberId subscriberId);


	/**
	 * Update entity.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param entry
	 *            the entry
	 */
	public void updateEntity(PublisherId publisherId, LosEntry entry);


	/**
	 * Adds the new entity.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param entry
	 *            the entry
	 */
	public void addNewEntity(PublisherId publisherId, LosEntry entry);


	/**
	 * Exists by natural id.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 * @return true, if successful
	 */
	public boolean existsByNaturalId(PublisherId publisherId, SubscriberId subscriberId);

}
