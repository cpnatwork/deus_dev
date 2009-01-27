package deus.core.gatekeeper.impl;

import deus.core.gatekeeper.LoginCredentialChecker;
import deus.core.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.model.user.transportid.LocalTransportId;

public class LoginCredentialCheckerStub implements LoginCredentialChecker {

	@Override
	public UserId check(LoginCredentials credentials) {
		UserId userId = new UserUrl("username", "deus.org");
		userId.addTransportId(new LocalTransportId("localUser"));
		return userId;
	}

}
