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
package deus.core.access.transfer.core.soul.observers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;
import deus.core.soul.gatekeeper.cerberus.CerberusExportedToSubsystems;
import deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver;
import deus.model.common.user.id.UserId;

/**
 * An asynchronous update interface for receiving notifications about
 * TransferProtocolLoginUserLoginState information as the
 * TransferProtocolLoginUserLoginState is constructed.
 */
@Named
public class TransferProtocolLoginUserLoginStateObserver implements UserLoginStateObserver {

	/** The transfer protocol registry. */
	@Inject
	private QueriableTransferProtocolRegistry transferProtocolRegistry;
	
	/** The cerberus. */
	@Inject
	private CerberusExportedToSubsystems cerberus;
	
	
	/**
	 * This method is called when information about an
	 * TransferProtocolLoginUserLoginState which was previously requested using
	 * an asynchronous interface becomes available.
	 */
	@PostConstruct	
	@SuppressWarnings("unused")
	private void addObserver() {
		cerberus.addUserLoginStateObserver(this);
	}
	

	/**
	 * This method is called when information about an
	 * TransferProtocolLoginUserLoginState which was previously requested using
	 * an asynchronous interface becomes available.
	 */
	@PreDestroy
	@SuppressWarnings("unused")
	private void removeObserver() {
		cerberus.removeUserLoginStateObserver(this);
	}
	
	
	/* (non-Javadoc)
	 * @see deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver#loggedIn(deus.model.common.user.id.UserId)
	 */
	@Override
	public void loggedIn(UserId userId) {
		for (String transferProtocolId : transferProtocolRegistry.getAllRegisteredTransferProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransferProtocol(transferProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getLoginEventCallback().loggedIn(transferId);
		}
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.gatekeeper.cerberus.UserLoginStateObserver#loggedOut(deus.model.common.user.id.UserId)
	 */
	@Override
	public void loggedOut(UserId userId) {
		for (String transferProtocolId : transferProtocolRegistry.getAllRegisteredTransferProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransferProtocol(transferProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getLoginEventCallback().loggedOut(transferId);
		}
	}

}
