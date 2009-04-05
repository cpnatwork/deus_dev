package deus.core.access.transfer.common.protocol.callback;

import deus.core.access.transfer.common.protocol.TransferId;

public class DefaultLoginEventCallback implements LoginEventCallback {

	@Override
	public void loggedIn(@SuppressWarnings("unused") TransferId transferId) {
		// DO NOTHING
	}


	@Override
	public void loggedOut(@SuppressWarnings("unused") TransferId transferId) {
		// DO NOTHING
	}

}
