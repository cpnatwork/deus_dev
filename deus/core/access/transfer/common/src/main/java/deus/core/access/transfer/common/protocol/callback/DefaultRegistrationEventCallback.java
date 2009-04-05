package deus.core.access.transfer.common.protocol.callback;

import deus.core.access.transfer.common.protocol.TransferId;

public class DefaultRegistrationEventCallback implements RegistrationEventCallback {

	@Override
	public void registered(@SuppressWarnings("unused") TransferId transferId) {
		// DO NOTHING
	}


	@Override
	public void unregistered(@SuppressWarnings("unused") TransferId transferId) {
		// DO NOTHING
	}

}
