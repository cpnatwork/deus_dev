package deus.gatekeeper.cerberus;

import deus.gatekeeper.soul.LoginCredentials;

public interface LoginCredentialChecker {

	public boolean isValid(LoginCredentials credentials);	

}
