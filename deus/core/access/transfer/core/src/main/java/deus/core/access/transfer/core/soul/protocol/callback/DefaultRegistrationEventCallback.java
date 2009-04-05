package deus.core.access.transfer.core.soul.protocol.callback;

import deus.core.access.transfer.core.soul.protocol.TransportId;

public class DefaultRegistrationEventCallback implements RegistrationEventCallback {

	@Override
	public void registered(@SuppressWarnings("unused") TransportId transportId) {
		// DO NOTHING
	}


	@Override
	public void unregistered(@SuppressWarnings("unused") TransportId transportId) {
		// DO NOTHING
	}

}
