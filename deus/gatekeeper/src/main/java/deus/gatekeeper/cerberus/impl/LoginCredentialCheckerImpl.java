package deus.gatekeeper.cerberus.impl;

import org.springframework.stereotype.Component;

import deus.gatekeeper.cerberus.LoginCredentialChecker;
import deus.gatekeeper.soul.LoginCredentials;

@Component
public class LoginCredentialCheckerImpl implements LoginCredentialChecker {

	@Override
	public boolean isValid(LoginCredentials credentials) {
		// FIXME: access database or use spring security here
		return true;
	}

}
