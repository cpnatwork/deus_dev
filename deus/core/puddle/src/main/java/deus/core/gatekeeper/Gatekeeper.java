package deus.core.gatekeeper;

import deus.core.User;
import deus.core.gatekeeper.soul.LoginCredentials;

public interface Gatekeeper {

	public User login(LoginCredentials credentials);
	
	public void logout(User user);
	
}
