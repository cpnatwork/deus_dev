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

import deus.core.access.storage.api.hci.attention.AttentionListDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionList;

/**
 * The Class AttentionListDaoImpl.
 */
@Named("attentionListDao")
public class AttentionListDaoImpl extends GenericVanillaDaoImpl<AttentionList, UserId> implements AttentionListDao {

	/* (non-Javadoc)
	 * @see deus.core.access.storage.api.hci.attention.AttentionListDao#getNoticedAttentionList(deus.model.common.user.id.UserId)
	 */
	@Override
	public AttentionList getNoticedAttentionList(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see deus.core.access.storage.api.hci.attention.AttentionListDao#getUnnoticedAttentionList(deus.model.common.user.id.UserId)
	 */
	@Override
	public AttentionList getUnnoticedAttentionList(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
