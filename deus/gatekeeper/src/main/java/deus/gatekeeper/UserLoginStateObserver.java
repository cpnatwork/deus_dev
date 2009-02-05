package deus.gatekeeper;

import deus.model.user.id.UserId;

public interface UserLoginStateObserver {

	public void loggedIn(String localUsername, UserId userId);


	public void loggedOut(String localUsername, UserId userId);

}
