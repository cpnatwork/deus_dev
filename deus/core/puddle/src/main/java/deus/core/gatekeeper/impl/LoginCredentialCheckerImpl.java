package deus.core.gatekeeper.impl;

import deus.core.gatekeeper.LoginCredentialChecker;
import deus.core.gatekeeper.soul.LoginCredentials;

public class LoginCredentialCheckerImpl implements LoginCredentialChecker {

	@Override
	public boolean isValid(LoginCredentials credentials) {
		// FIXME: access database or use spring security here
		return true;
	}

}
