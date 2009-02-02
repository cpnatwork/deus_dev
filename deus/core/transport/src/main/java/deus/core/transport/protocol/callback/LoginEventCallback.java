package deus.core.transport.protocol.callback;

import deus.core.transport.protocol.TransportId;

public interface LoginEventCallback {

	public void loggedIn(TransportId transportId);
	
	public void loggedOut(TransportId transportId);
	
}
