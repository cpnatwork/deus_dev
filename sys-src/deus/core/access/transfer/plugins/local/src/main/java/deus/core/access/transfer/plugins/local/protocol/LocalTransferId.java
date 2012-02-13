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
package deus.core.access.transfer.plugins.local.protocol;

import deus.core.access.transfer.common.protocol.TransferId;

/**
 * The Class LocalTransferId.
 */
public class LocalTransferId implements TransferId {

	/** The username. */
	private final String username;

	/**
	 * Instantiates a new local transfer id.
	 * 
	 * @param username
	 *            the username
	 */
	public LocalTransferId(final String username) {
		super();
		this.username = username;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.transfer.common.protocol.TransferId#getTransferProtocolId
	 * ()
	 */
	@Override
	public String getTransferProtocolId() {
		return "local";
	}

}
