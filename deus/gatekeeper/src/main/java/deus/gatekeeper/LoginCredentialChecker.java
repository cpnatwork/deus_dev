package deus.gatekeeper;

import deus.gatekeeper.soul.LoginCredentials;

public interface LoginCredentialChecker {

	public boolean isValid(LoginCredentials credentials);	

}
