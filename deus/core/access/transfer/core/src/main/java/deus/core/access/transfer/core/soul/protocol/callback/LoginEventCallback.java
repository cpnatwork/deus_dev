package deus.core.access.transfer.core.soul.protocol.callback;

import deus.core.access.transfer.core.soul.protocol.TransferId;

public interface LoginEventCallback {

	public void loggedIn(TransferId transferId);
	
	public void loggedOut(TransferId transferId);
	
}
