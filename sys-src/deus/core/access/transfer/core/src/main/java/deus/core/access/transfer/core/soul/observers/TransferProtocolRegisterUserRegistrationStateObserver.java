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
import deus.core.soul.accountadmin.registrator.RegistratorExportedToSubsystems;
import deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver;
import deus.model.common.user.id.UserId;

/**
 * An asynchronous update interface for receiving notifications about
 * TransferProtocolRegisterUserRegistrationState information as the
 * TransferProtocolRegisterUserRegistrationState is constructed.
 */
@Named
public class TransferProtocolRegisterUserRegistrationStateObserver implements UserRegistrationStateObserver {

	/** The transfer protocol registry. */
	@Inject
	private QueriableTransferProtocolRegistry transferProtocolRegistry;
	
	/** The registrator. */
	@Inject
	private RegistratorExportedToSubsystems registrator;
	
		
	/**
	 * This method is called when information about an
	 * TransferProtocolRegisterUserRegistrationState which was previously
	 * requested using an asynchronous interface becomes available.
	 */
	@PostConstruct	
	@SuppressWarnings("unused")
	private void addObserver() {
		registrator.addUserRegistrationStateObserver(this);
	}
	

	/**
	 * This method is called when information about an
	 * TransferProtocolRegisterUserRegistrationState which was previously
	 * requested using an asynchronous interface becomes available.
	 */
	@PreDestroy
	@SuppressWarnings("unused")
	private void removeObserver() {
		registrator.removeUserRegistrationStateObserver(this);
	}
	
	
	
	/* (non-Javadoc)
	 * @see deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver#registered(deus.model.common.user.id.UserId)
	 */
	@Override
	public void registered(UserId userId) {
		for (String transferProtocolId : transferProtocolRegistry.getAllRegisteredTransferProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransferProtocol(transferProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getRegistrationEventCallback().registered(transferId);
		}
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver#unregistered(deus.model.common.user.id.UserId)
	 */
	@Override
	public void unregistered(UserId userId) {
		for (String transferProtocolId : transferProtocolRegistry.getAllRegisteredTransferProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransferProtocol(transferProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getRegistrationEventCallback().unregistered(transferId);
		}
	}

}
