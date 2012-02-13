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
package deus.core.access.storage.api.hci.attention;

import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;

/**
 * The Interface AttentionElementDao.
 */
public interface AttentionElementDao {

	/**
	 * Adds the new entity.
	 * 
	 * @param userId
	 *            the user id
	 * @param attentionElement
	 *            the attention element
	 */
	public void addNewEntity(UserId userId, AttentionElement attentionElement);

	/**
	 * Update entity.
	 * 
	 * @param userId
	 *            the user id
	 * @param attentionElement
	 *            the attention element
	 */
	public void updateEntity(UserId userId, AttentionElement attentionElement);

}
