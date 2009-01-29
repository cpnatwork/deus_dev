package deus.core.transport.callback;

import deus.core.transport.id.TransportId;
import deus.model.user.UserMetadata;

public class DefaultLoginEventCallback implements LoginEventCallback {

	@Override
	public void loggedIn(UserMetadata userMetadata, TransportId transportId, String password) {
	}


	@Override
	public void loggedOut(TransportId transportId) {
	}

}
