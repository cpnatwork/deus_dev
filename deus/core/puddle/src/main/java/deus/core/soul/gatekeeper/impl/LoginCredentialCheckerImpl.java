package deus.core.soul.gatekeeper.impl;

import deus.core.soul.gatekeeper.LoginCredentialChecker;
import deus.core.soul.gatekeeper.soul.LoginCredentials;

public class LoginCredentialCheckerImpl implements LoginCredentialChecker {

	@Override
	public boolean isValid(LoginCredentials credentials) {
		// FIXME: access database or use spring security here
		return true;
	}

}
