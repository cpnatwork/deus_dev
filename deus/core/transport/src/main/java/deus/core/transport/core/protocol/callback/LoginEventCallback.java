package deus.core.transport.core.protocol.callback;

import deus.core.transport.core.protocol.TransportId;

public interface LoginEventCallback {

	public void loggedIn(TransportId transportId);
	
	public void loggedOut(TransportId transportId);
	
}
