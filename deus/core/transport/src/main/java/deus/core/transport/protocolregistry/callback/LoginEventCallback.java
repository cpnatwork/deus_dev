package deus.core.transport.protocolregistry.callback;

import deus.core.transport.id.TransportId;

public interface LoginEventCallback {

	public void loggedIn(TransportId transportId, String password);
	
	public void loggedOut(TransportId transportId);
	
}
