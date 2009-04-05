package deus.core.access.transfer.common.protocol.callback;

import deus.core.access.transfer.common.protocol.TransferId;

public interface RegistrationEventCallback {

	public void registered(TransferId transferId);
	
	public void unregistered(TransferId transferId);
	
}
