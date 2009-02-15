package deus.gatekeeper;

import deus.gatekeeper.soul.LoginCredentials;

public interface Cerberus {

	public void login(LoginCredentials credentials);


	public void logout(String localUsername);

	
	public void addUserLoginStateObserver(UserLoginStateObserver observer);
	
	public void removeUserLoginStateObserver(UserLoginStateObserver observer);
}
