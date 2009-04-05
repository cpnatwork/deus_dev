package deus.core.access.transport.core.soul.protocol.callback;

import deus.core.access.transport.core.soul.protocol.TransportId;

public interface LoginEventCallback {

	public void loggedIn(TransportId transportId);
	
	public void loggedOut(TransportId transportId);
	
}
