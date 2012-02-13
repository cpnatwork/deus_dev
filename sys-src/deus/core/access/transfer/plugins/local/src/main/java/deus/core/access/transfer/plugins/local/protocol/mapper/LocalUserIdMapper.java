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
package deus.core.access.transfer.plugins.local.protocol.mapper;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.plugins.local.protocol.LocalTransferId;
import deus.model.common.user.id.UserId;

/**
 * Returns local transfer IDs, where the username is just taken from the UserId.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class LocalUserIdMapper implements UserIdMapper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.transfer.common.protocol.mapper.UserIdMapper#resolveLocal
	 * (deus.model.common.user.id.UserId)
	 */
	@Override
	public TransferId resolveLocal(final UserId userId) {
		return new LocalTransferId(userId.getUsername() + "/local");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.transfer.common.protocol.mapper.UserIdMapper#resolveRemote
	 * (deus.model.common.user.id.UserId)
	 */
	@Override
	public TransferId resolveRemote(final UserId userId) {
		// FIXME: Implement this by using discovery
		// it should stay here, but maybe use discovery helper classes from
		// transfer-core

		return new LocalTransferId(userId.getUsername() + "/local");
	}

}
