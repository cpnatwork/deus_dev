package deus.core.access.transfer.common.protocol.callback;

import deus.core.access.transfer.common.protocol.TransferId;

public interface LoginEventCallback {

	public void loggedIn(TransferId transferId);
	
	public void loggedOut(TransferId transferId);
	
}
