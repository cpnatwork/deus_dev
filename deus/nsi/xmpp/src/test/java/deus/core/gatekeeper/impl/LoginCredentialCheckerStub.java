package deus.core.gatekeeper.impl;

import deus.core.soul.gatekeeper.LoginCredentialChecker;
import deus.core.soul.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.model.user.transportid.LocalTransportId;
import deus.model.user.transportid.XmppTransportId;

public class LoginCredentialCheckerStub implements LoginCredentialChecker {

	@Override
	public UserId check(LoginCredentials credentials) {
		UserId userId = new UserUrl(credentials.getUsername(), "deus.org");
		userId.addTransportId(new LocalTransportId(credentials.getUsername() + "_local"));
		userId.addTransportId(new XmppTransportId(credentials.getUsername(), "faui6p15"));
		return userId;
	}

}
