package deus.core.access.transfer.core.soul.observers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.core.access.transfer.common.protocol.TransferProtocol;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;
import deus.core.soul.accountadmin.registrator.RegistratorExportedToSubsystems;
import deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver;
import deus.model.user.id.UserId;

@Component
public class TransferProtocolRegisterUserRegistrationStateObserver implements UserRegistrationStateObserver {

	@Autowired
	private QueriableTransferProtocolRegistry transferProtocolRegistry;
	
	@Autowired
	private RegistratorExportedToSubsystems registrator;
	
		
	@PostConstruct	
	@SuppressWarnings("unused")
	private void addObserver() {
		registrator.addUserRegistrationStateObserver(this);
	}
	

	@PreDestroy
	@SuppressWarnings("unused")
	private void removeObserver() {
		registrator.removeUserRegistrationStateObserver(this);
	}
	
	
	
	@Override
	public void registered(UserId userId) {
		for (String transferProtocolId : transferProtocolRegistry.getAllRegisteredTransferProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransferProtocol(transferProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getRegistrationEventCallback().registered(transferId);
		}
	}


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
