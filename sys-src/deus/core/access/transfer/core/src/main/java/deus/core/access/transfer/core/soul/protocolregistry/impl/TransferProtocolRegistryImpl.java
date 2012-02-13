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
package deus.core.access.transfer.core.soul.protocolregistry.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;

/**
 * The Class TransferProtocolRegistryImpl.
 */
@Named("transferProtocolRegistry")
public class TransferProtocolRegistryImpl implements QueriableTransferProtocolRegistry {

	/** The registered transfer protocols. */
	private final Map<String, TransferProtocol> registeredTransferProtocols;


	/**
	 * Instantiates a new transfer protocol registry impl.
	 */
	public TransferProtocolRegistryImpl() {
		super();
		this.registeredTransferProtocols = new HashMap<String, TransferProtocol>();
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry#getRegisteredTransferProtocol(java.lang.String)
	 */
	@Override
	public TransferProtocol getRegisteredTransferProtocol(String transferProtocolId) {
		return registeredTransferProtocols.get(transferProtocolId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocolregistry.TransferProtocolRegistry#registerTransferProtocol(deus.core.access.transfer.common.protocol.TransferProtocol)
	 */
	@Override
	public void registerTransferProtocol(TransferProtocol transferProtocol) {
		if (registeredTransferProtocols.containsKey(transferProtocol.getProtocolId()))
			throw new IllegalArgumentException("transfer protocol " + transferProtocol
					+ " has already been registered!");

		registeredTransferProtocols.put(transferProtocol.getProtocolId(), transferProtocol);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.common.protocolregistry.TransferProtocolRegistry#unregisterTransferProtocol(java.lang.String)
	 */
	@Override
	public void unregisterTransferProtocol(String transferProtocolId) {
		if (!registeredTransferProtocols.containsKey(transferProtocolId))
			throw new IllegalArgumentException("transfer protocol " + transferProtocolId + " was not registered!");
		registeredTransferProtocols.remove(transferProtocolId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry#getAllRegisteredTransferProtocolIds()
	 */
	@Override
	public Collection<String> getAllRegisteredTransferProtocolIds() {
		return registeredTransferProtocols.keySet();
	}

}
