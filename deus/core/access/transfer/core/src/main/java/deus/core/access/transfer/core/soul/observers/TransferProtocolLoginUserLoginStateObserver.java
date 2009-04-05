package deus.core.access.transfer.core.soul.observers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.TransferId;
import deus.core.access.transfer.core.soul.protocol.TransferProtocol;
import deus.core.access.transfer.core.soul.protocolregistry.TransferProtocolRegistry;
import deus.gatekeeper.cerberus.UserLoginStateObserver;
import deus.model.user.id.UserId;

@Component
public class TransferProtocolLoginUserLoginStateObserver implements UserLoginStateObserver {

	@Autowired
	private TransferProtocolRegistry transferProtocolRegistry;
	
	@Override
	public void loggedIn(UserId userId) {
		for (String transferProtocolId : transferProtocolRegistry.getAllRegisteredTransferProtocolIds()) {
			TransferProtocol tp = transferProtocolRegistry.getRegisteredTransferProtocol(transferProtocolId);
			UserIdMapper userIdMapper = tp.getUserIdMapper();
			TransferId transferId = userIdMapper.resolveLocal(userId);
			tp.getLoginEventCallback().loggedIn(transferId);
		}
	}


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
