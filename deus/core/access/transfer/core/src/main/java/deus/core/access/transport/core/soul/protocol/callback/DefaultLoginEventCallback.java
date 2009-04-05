package deus.core.access.transport.core.soul.protocol.callback;

import deus.core.access.transport.core.soul.protocol.TransportId;

public class DefaultLoginEventCallback implements LoginEventCallback {

	@Override
	public void loggedIn(@SuppressWarnings("unused") TransportId transportId) {
		// DO NOTHING
	}


	@Override
	public void loggedOut(@SuppressWarnings("unused") TransportId transportId) {
		// DO NOTHING
	}

}
