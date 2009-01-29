package deus.core.transport.callback;

import deus.core.transport.id.TransportId;

public interface LoginEventCallback {

	public void loggedIn(TransportId transportId);
	
	public void loggedOut(TransportId transportId);
	
}
