package deus.core.transport.callback;

import deus.core.transport.id.TransportId;
import deus.model.user.UserMetadata;

public interface LoginEventCallback {

	public void loggedIn(UserMetadata userMetadata, TransportId transportId, String password);
	
	public void loggedOut(TransportId transportId);
	
}
