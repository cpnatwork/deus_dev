package deus.core.gatekeeper;

import deus.core.User;
import deus.core.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;

public interface Gatekeeper {

	public User login(LoginCredentials credentials);
	
	public void logout(User user);
	
}
