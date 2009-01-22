package deus.core.gatekeeper;

import deus.core.gatekeeper.soul.LoginCredentials;
import deus.model.user.id.UserId;

public interface LoginCredentialChecker {

	public UserId check(LoginCredentials credentials);	

}
