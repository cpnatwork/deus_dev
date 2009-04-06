package deus.gatekeeper.cerberus;

import deus.model.gatekeeper.LoginCredentials;

public interface LoginCredentialChecker {

	public boolean isValid(LoginCredentials credentials);	

}
