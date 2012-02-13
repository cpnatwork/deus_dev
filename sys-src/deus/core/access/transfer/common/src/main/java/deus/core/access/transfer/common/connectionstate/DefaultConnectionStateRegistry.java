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
package deus.core.access.transfer.common.connectionstate;

import java.util.HashMap;
import java.util.Map;

import deus.core.access.transfer.common.protocol.TransferId;

/**
 * The Class DefaultConnectionStateRegistry.
 */
public class DefaultConnectionStateRegistry implements ConnectionStateRegistry {

	/** The connection states. */
	private final Map<TransferId, ConnectionState> connectionStates;


	/**
	 * Instantiates a new default connection state registry.
	 */
	public DefaultConnectionStateRegistry() {
		this.connectionStates = new HashMap<TransferId, ConnectionState>();
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.connectionstate.ConnectionStateRegistry#addConnectionState(deus.core.access.transfer.common.protocol.TransferId, deus.core.access.transfer.common.connectionstate.ConnectionState)
	 */
	@Override
	public void addConnectionState(TransferId transferId, ConnectionState connectionState) {
		if (hasConnectionState(transferId))
			throw new IllegalStateException("cannot add connection state for transfer id " + transferId
					+ ", there already is a connection state for this transfer id");
		
		connectionStates.put(transferId, connectionState);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.connectionstate.ConnectionStateRegistry#getConnectionState(deus.core.access.transfer.common.protocol.TransferId)
	 */
	@Override
	public ConnectionState getConnectionState(TransferId transferId) {
		if (!hasConnectionState(transferId))
			throw new IllegalStateException("cannot get connection state for transfer id " + transferId
					+ ", there is no connection state for this transfer id");

		return connectionStates.get(transferId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.connectionstate.ConnectionStateRegistry#hasConnectionState(deus.core.access.transfer.common.protocol.TransferId)
	 */
	@Override
	public boolean hasConnectionState(TransferId transferId) {
		return connectionStates.containsKey(transferId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.connectionstate.ConnectionStateRegistry#removeConnectionState(deus.core.access.transfer.common.protocol.TransferId)
	 */
	@Override
	public void removeConnectionState(TransferId transferId) {
		if (!hasConnectionState(transferId))
			throw new IllegalStateException("cannot remove connection state for transfer id " + transferId
					+ ", there is no connection state for this transfer id");

		connectionStates.remove(transferId);
	}

}
