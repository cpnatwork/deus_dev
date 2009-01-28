package deus.core.gatekeeper;

import deus.core.gatekeeper.soul.LoginCredentials;

public interface Gatekeeper {

	public void login(LoginCredentials credentials);


	public void logout(String localUsername);

}
