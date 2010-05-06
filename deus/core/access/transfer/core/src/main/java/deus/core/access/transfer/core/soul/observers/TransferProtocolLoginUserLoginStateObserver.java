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

@Named
public class TransferProtocolLoginUserLoginStateObserver implements UserLoginStateObserver {

	@Inject
	private QueriableTransferProtocolRegistry transferProtocolRegistry;
	
	@Inject
	private CerberusExportedToSubsystems cerberus;
	
	
	@PostConstruct	
	@SuppressWarnings("unused")
	private void addObserver() {
		cerberus.addUserLoginStateObserver(this);
	}
	

	@PreDestroy
	@SuppressWarnings("unused")
	private void removeObserver() {
		cerberus.removeUserLoginStateObserver(this);
	}
	
	
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
