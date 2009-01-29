package deus.core.soul.gatekeeper;

import deus.model.user.UserMetadata;

public interface UserLoginStateObserver {

	public void loggedIn(UserMetadata userMetadata);


	public void loggedOut(UserMetadata userMetadata);

}
