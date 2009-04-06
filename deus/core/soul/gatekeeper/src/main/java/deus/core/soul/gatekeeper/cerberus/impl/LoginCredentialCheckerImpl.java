package deus.core.soul.gatekeeper.cerberus.impl;

import org.springframework.stereotype.Component;

import deus.core.soul.gatekeeper.cerberus.LoginCredentialChecker;
import deus.model.gatekeeper.LoginCredentials;

@Component
public class LoginCredentialCheckerImpl implements LoginCredentialChecker {

	@Override
	public boolean isValid(LoginCredentials credentials) {
		// FIXME: access database or use spring security here
		return true;
	}

}
