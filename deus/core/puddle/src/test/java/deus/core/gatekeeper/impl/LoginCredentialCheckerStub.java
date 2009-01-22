package deus.core.gatekeeper.impl;

import deus.core.gatekeeper.LoginCredentialChecker;
import deus.core.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

public class LoginCredentialCheckerStub implements LoginCredentialChecker {

	@Override
	public UserId check(LoginCredentials credentials) {
		return new UserUrl("username", "deus.org");
	}

}
