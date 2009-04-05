package deus.core.access.transfer.core.soul.observers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.TransferId;
import deus.core.access.transfer.core.soul.protocol.TransferProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.TransferProtocolRegistry;
import deus.gatekeeper.registrator.UserRegistrationStateObserver;
import deus.model.user.id.UserId;

@Component
public class TransferProtocolRegisterUserRegistrationStateObserver implements UserRegistrationStateObserver {

	@Autowired
	private TransferProtocolRegistry transferProtocolRegistry;
	
	
	@Override
	public void registered(UserId userId) {
		for (String transportProtocolId : transferProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getRegistrationEventCallback().registered(transferId);
		}
	}


	@Override
	public void unregistered(UserId userId) {
		for (String transportProtocolId : transferProtocolRegistry.getAllRegisteredTransportProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getRegistrationEventCallback().unregistered(transferId);
		}
	}

}
