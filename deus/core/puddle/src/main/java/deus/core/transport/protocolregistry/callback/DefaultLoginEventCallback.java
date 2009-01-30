package deus.core.transport.protocolregistry.callback;

import deus.core.transport.id.TransportId;

public class DefaultLoginEventCallback implements LoginEventCallback {

	@Override
	public void loggedIn(TransportId transportId, String password) {
	}


	@Override
	public void loggedOut(TransportId transportId) {
	}

}
