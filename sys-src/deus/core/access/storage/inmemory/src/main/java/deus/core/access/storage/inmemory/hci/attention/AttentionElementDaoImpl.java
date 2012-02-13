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
package deus.core.access.storage.inmemory.hci.attention;

import javax.inject.Named;

import deus.core.access.storage.api.hci.attention.AttentionElementDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionElement;

/**
 * The Class AttentionElementDaoImpl.
 */
@Named("attentionElementDao")
public class AttentionElementDaoImpl extends GenericTwofoldIdDaoImpl<AttentionElement, UserId, Integer> implements
		AttentionElementDao {

	/* (non-Javadoc)
	 * @see deus.core.access.storage.api.hci.attention.AttentionElementDao#addNewEntity(deus.model.common.user.id.UserId, deus.model.hci.attention.AttentionElement)
	 */
	@Override
	public void addNewEntity(UserId userId, AttentionElement attentionElement) {
		super.addNewEntity(userId, attentionElement.getId(), attentionElement);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.storage.api.hci.attention.AttentionElementDao#updateEntity(deus.model.common.user.id.UserId, deus.model.hci.attention.AttentionElement)
	 */
	@Override
	public void updateEntity(UserId userId, AttentionElement attentionElement) {
		super.updateEntity(userId, attentionElement.getId(), attentionElement);
	}

}
