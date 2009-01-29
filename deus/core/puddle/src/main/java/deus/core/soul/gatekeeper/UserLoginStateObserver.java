package deus.core.soul.gatekeeper;

import deus.model.user.id.UserId;

public interface UserLoginStateObserver {

	public void loggedIn(UserId userId);


	public void loggedOut(UserId userId);

}
