package deus.gatekeeper.impl;

import org.springframework.stereotype.Component;

import deus.gatekeeper.LoginCredentialChecker;
import deus.gatekeeper.soul.LoginCredentials;

@Component
public class LoginCredentialCheckerImpl implements LoginCredentialChecker {

	@Override
	public boolean isValid(LoginCredentials credentials) {
		// FIXME: access database or use spring security here
		return true;
	}

}
