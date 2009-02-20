package deus.gatekeeper.cerberus;

import deus.gatekeeper.puddle.LoginCredentials;

public interface LoginCredentialChecker {

	public boolean isValid(LoginCredentials credentials);	

}
