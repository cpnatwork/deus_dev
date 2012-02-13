package deus.core.soul.gatekeeper.cerberus;

import deus.model.common.user.id.UserId;

public interface UserLoginStateObserver {

	public void loggedIn(UserId userId);


	public void loggedOut(UserId userId);

}
