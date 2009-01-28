package deus.core.gatekeeper;

import deus.core.gatekeeper.soul.LoginCredentials;

public interface LoginCredentialChecker {

	public boolean isValid(LoginCredentials credentials);	

}
