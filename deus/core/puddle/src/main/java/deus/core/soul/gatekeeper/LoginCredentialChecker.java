package deus.core.soul.gatekeeper;

import deus.core.soul.gatekeeper.soul.LoginCredentials;

public interface LoginCredentialChecker {

	public boolean isValid(LoginCredentials credentials);	

}
